package br.com.nca.financasapi.infrastructure.components;

import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.responses.Response;
import com.openai.models.responses.ResponseCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OpenAIComponent {

    @Value("${openai.key}")
    private String openAiKey;

    public String send(String prompt) throws RuntimeException {

        OpenAIClient client = OpenAIOkHttpClient.builder()
                .apiKey(openAiKey)
                .build();

        ResponseCreateParams params = ResponseCreateParams.builder()
                .input(prompt)
                .model(ChatModel.GPT_4_1)
                .build();

        Response response = client.responses().create(params);
        return response.output().toString();
    }
}
