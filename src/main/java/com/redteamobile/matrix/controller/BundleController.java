package com.redteamobile.matrix.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.util.JsonFormat;
import com.redteamobile.matrix.model.page.ResponseStruct;
import com.redteamobile.matrix.service.GagaProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yoruichi on 17/9/7.
 */
@RestController
@RequestMapping("/bundle")
public class BundleController extends BaseController {
    @Autowired
    private GagaProviderClient client;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public JsonNode list(@RequestParam String merchantCode) throws Exception {
        return new ObjectMapper().readTree(JsonFormat.printer().print(client.listBundle(merchantCode)));
    }
}
