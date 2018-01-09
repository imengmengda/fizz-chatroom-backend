package com.follower.fizz.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lin on 17-12-20.
 */
public final class SendMessageUtil {

    public static void sendMessage(HttpServletResponse httpResponse, Object object) {
        ObjectMapper objectMapper = new ObjectMapper();

        String respnseStr = null;

        if (object.getClass().equals(String.class)) {
            respnseStr = (String)object;
        } else {
            try {
                respnseStr = objectMapper.writeValueAsString(object);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        httpResponse.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = null;
        try {
            printWriter = httpResponse.getWriter();
            printWriter.write(respnseStr);
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        }

        printWriter.flush();
        printWriter.close();
    }
}
