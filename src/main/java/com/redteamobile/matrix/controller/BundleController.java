package com.redteamobile.matrix.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.protobuf.util.JsonFormat;
import com.redteamobile.matrix.model.page.ResponseStruct;
import com.redteamobile.matrix.pb.Reply2ListBundle;
import com.redteamobile.matrix.service.GagaProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nullable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

/**
 * Created by yoruichi on 17/9/7.
 */
@RestController
@RequestMapping("/bundle")
public class BundleController extends BaseController {
    @Autowired
    private GagaProviderClient client;
    @Autowired
    private Executor executor;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public JsonNode list(@RequestParam String merchantCode) throws Exception {
        return new ObjectMapper().readTree(JsonFormat.printer().print(client.listBundle(merchantCode)));
    }

    @RequestMapping(value = "/asnyc/list", method = RequestMethod.GET)
    public ResponseStruct listAsnyc(@RequestParam String merchantCode) throws Exception {
        Bundle bundle = new Bundle();
        ListenableFuture<Reply2ListBundle> reply =
                client.listBundleAsnyc(merchantCode);
        reply.addListener(()->{
            System.out.println("i'm running in listener future with thread >>> " + Thread.currentThread().getName());
        }, executor); // 可以通过此种方式来异步执行获取Response之后的代码逻辑
        Futures.addCallback(reply, new FutureCallback<Reply2ListBundle>() {
            @Override public void onSuccess(@Nullable Reply2ListBundle result) {
                System.out.println("i'm running after future success in thread >>> " + Thread.currentThread().getName());
                if (result == null)
                    bundle.id = -1;
                else
                    bundle.id = result.getBundles(0).getId();
                System.out.println(bundle.id);
            }

            @Override public void onFailure(Throwable t) {
                System.out.println("i'm running after future failed with thread >>> " + Thread.currentThread().getName());
                bundle.id = -1;
                System.out.println(bundle.id);
            }
        }, executor);
        System.out.println("i'm running in main with thread >>> " + Thread.currentThread().getName());
        while (bundle.id == 0) Thread.sleep(1000);
        return succ(bundle);
    }

    class Bundle {
        int id;

        public int getId() {
            return id;
        }

        public Bundle setId(int id) {
            this.id = id;
            return this;
        }
    }
}
