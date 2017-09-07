package com.redteamobile.matrix.controller;

import com.redteamobile.matrix.i18n.LocaleMessageSource;
import com.redteamobile.matrix.model.page.ResponseStruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Component
public class BaseController {

    // 资源的国际化和数据库层面的国际化都应该放在这里
    @Autowired
    protected LocaleMessageSource localeMessageSource;

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public void downloadFile(HttpServletResponse response, String file, String fileName)
            throws Exception {
        downloadFile(response, new File(file), fileName);
    }

    public void downloadFileWithGBK(HttpServletResponse response, String file, String fileName)
            throws Exception {
        downloadFileWithGBK(response, new File(file), fileName);
    }

    public void downloadFileWithGBK(HttpServletResponse response, File file, String fileName)
            throws Exception {
        response.setHeader("content-type", "application/vnd.ms-excel");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition",
                "attachment; filename=" + fileName);
        BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line = null;
        try {
            while ((line = br.readLine()) != null) {
                bos.write(line.getBytes("GBK"));
                bos.write("\n".getBytes("GBK"));
            }
            bos.flush();
        } finally {
            bos.close();
            br.close();
        }
    }

    public void downloadFile(HttpServletResponse response, File file, String fileName)
            throws Exception {
        response.setHeader("conent-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition",
                "attachment; filename=" + fileName);
        BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
        InputStream is = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(is);
        int length = 0;
        byte[] temp = new byte[1 * 1024 * 10];
        while ((length = bis.read(temp)) != -1) {
            bos.write(temp, 0, length);
        }
        bos.flush();
        bis.close();
        bos.close();
        is.close();
    }

    public ResponseStruct failedWithMsg(String msg) {
        return ResponseStruct.build().setMsg(msg).setSuccess(false);
    }

    public ResponseStruct failed(String code) {
        return ResponseStruct.build().setMsg(localeMessageSource.getMessage(code)).setSuccess(false)
                .setCode(code);
    }

    public <T extends ResponseStruct> T succ(T res) {
        res.setSuccess(true);
        return res;
    }

    public ResponseStruct succ(Object obj) {
        return ResponseStruct.build().setSuccess(true).setObj(obj);
    }

    public ResponseStruct succ() {
        return ResponseStruct.build().setSuccess(true);
    }

}
