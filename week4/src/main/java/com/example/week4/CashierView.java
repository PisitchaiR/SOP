package com.example.week4;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.reactive.function.client.WebClient;

@Route(value = "index2")
public class CashierView extends VerticalLayout {
    private TextField b1000, b500,b100, b20, b10,b5,b1, input;
    private Button btnCal;

    public CashierView() {
        input = new TextField("");
        input.setLabel("เงินทอน");
        input.setPrefixComponent(new Div(new Text("$")));
        btnCal = new Button("คำนวนเงินทอน");
        b1000 = new TextField();
        b500 = new TextField();
        b100 = new TextField();
        b20 = new TextField();
        b10 = new TextField();
        b5 = new TextField();
        b1 = new TextField();
        b1000.setPrefixComponent(new Div(new Text("$1000: ")));
        b500.setPrefixComponent(new Div(new Text("$500: ")));
        b100.setPrefixComponent(new Div(new Text("$100: ")));
        b20.setPrefixComponent(new Div(new Text("$20: ")));
        b10.setPrefixComponent(new Div(new Text("$10: ")));
        b5.setPrefixComponent(new Div(new Text("$5: ")));
        b1.setPrefixComponent(new Div(new Text("$1: ")));

        this.add(input, btnCal, b1000, b500,b100, b20, b10,b5,b1);

        btnCal.addClickListener(event -> {
            int num1 = Integer.parseInt(input.getValue());
            Change out = WebClient.create()
                    .get()
                    .uri("http://localhost:8080/getChange/"+num1)
                    .retrieve()
                    .bodyToMono(Change.class)
                    .block();

            b1000.setValue(out.getB1000()+"");
            b500.setValue(out.getB500()+"");
            b100.setValue(out.getB100()+"");
            b20.setValue(out.getB20()+"");
            b10.setValue(out.getB10()+"");
            b5.setValue(out.getB5()+"");
            b1.setValue(out.getB1()+"");
        });
    }
}
