package com.example.dateanu.repository;

import com.example.dateanu.domain.client.Client;
import com.example.dateanu.domain.client.ClientRepository;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import net.minidev.json.JSONObject;
import org.aspectj.lang.annotation.Before;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

@SpringBootTest
class ClientRepositoryTest {
    @Autowired
    private ClientRepository clientRepository;
    private final JSONObject jsonClient = new JSONObject();

    @BeforeEach
    public void init() throws JSONException {
        jsonClient.put("studentId", "20181097");
        jsonClient.put("email", "john.doe@example.com");
        jsonClient.put("phoneNum", "010-1234-1234");
        jsonClient.put("name", "John Doe");
        jsonClient.put("hasExcludeAcquaintance", "true");
    }

    @Test
    @Transactional
    @DisplayName("고객 저장 테스트")
    void saveClient(){
        try {
            // GIVEN
            Client client = castToClient(jsonClient);

            // WHEN
            Client savedClient = clientRepository.save(client);

            // THEN
            // 일단 눈으로 한 번 봐보자구 ㅋㅋㅋㅋ
            System.out.println(savedClient.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    Client castToClient(@RequestBody JSONObject jsonClient) throws Exception{
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Client jsonToClient = objectMapper.readValue(jsonClient.toJSONString(), Client.class);
            return jsonToClient;
        } catch (JsonMappingException e) {
            e.printStackTrace();
            throw e;
        } catch (JsonGenerationException e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } catch(Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}