package com.example.week4;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Route(value = "index1")
public class View extends FormLayout {
    private TextField n1, n2, answer, group;
    private Button btnPlus, btnMinus, btnMultiply, btnDivide, btnMod, btnMax;

    public View() {
        n1 = new TextField("Number 1");
        n2 = new TextField("Number 2");
        btnPlus = new Button("+");

        btnMinus = new Button("-");
        btnMultiply = new Button("x");
        btnDivide = new Button("/");
        btnMod = new Button("Mod");
        btnMax = new Button("Max");
        answer = new TextField("Answer");
        group = new TextField();

        HorizontalLayout h1 = new HorizontalLayout();
        HorizontalLayout h2 = new HorizontalLayout();
        VerticalLayout v1 = new VerticalLayout();
        Label label = new Label("Operator");
        h1.add(n1,n2);
        h2.add(btnPlus, btnMinus, btnMultiply, btnDivide, btnMod, btnMax);
        v1.add(h1,label, h2 , answer);
        this.add(v1);


        btnPlus.addClickListener(event -> {
            double num1 = Double.parseDouble((n1.getValue()));
            double num2 = Double.parseDouble((n2.getValue()));

            getPlus(num1, num2);
        });
        btnMinus.addClickListener(event -> {
            double num1 = Double.parseDouble((n1.getValue()));
            double num2 = Double.parseDouble((n2.getValue()));

            getMinus(num1, num2);
        });
        btnDivide.addClickListener(event -> {
            double num1 = Double.parseDouble((n1.getValue()));
            double num2 = Double.parseDouble((n2.getValue()));

            getDivide(num1, num2);
        });
        btnMultiply.addClickListener(event -> {
            double num1 = Double.parseDouble((n1.getValue()));
            double num2 = Double.parseDouble((n2.getValue()));

            getMulit(num1, num2);
        });
        btnMod.addClickListener(event -> {
            double num1 = Double.parseDouble((n1.getValue()));
            double num2 = Double.parseDouble((n2.getValue()));

            getMod(num1 ,num2);
        });
        btnMax.addClickListener(event -> {
            MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
            formData.add("n1", n1.getValue());
            formData.add("n2", n2.getValue());

            String out = WebClient.create()
                    .post()
                    .uri("http://127.0.0.1:8090/max")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .body(BodyInserters.fromFormData(formData))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            answer.setValue(out);
        });
    }

    private void getPlus(double num1, double num2) {
        String out = WebClient.create()
                .get()
                .uri("http://127.0.0.1:8090/plus/"+num1+"/"+num2)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        answer.setValue(out);
    }

    private void getMinus(double num1, double num2){
        String out = WebClient.create()
                .get()
                .uri("http://127.0.0.1:8090/minus/"+num1+"/"+num2)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        answer.setValue(out);
    }

    private void getDivide(double num1, double num2){
        String out = WebClient.create()
                .get()
                .uri("http://127.0.0.1:8090/divide/"+num1+"/"+num2)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        answer.setValue(out);
    }

    private void getMulit(double num1, double num2){
        String out = WebClient.create()
                .get()
                .uri("http://127.0.0.1:8090/multi/"+num1+"/"+num2)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        answer.setValue(out);
    }

    private void getMod(double num1, double num2){
        String out = WebClient.create()
                .get()
                .uri("http://127.0.0.1:8090/mod/"+num1+"/"+num2)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        answer.setValue(out);
    }

}
