package com.example.sop_final_63070121.View;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;


@Route(value="/product")
public class ProductView extends VerticalLayout {
    public ProductView() {
        ComboBox<String> pList = new ComboBox<>();
        pList.setWidth("600px");
        pList.setLabel("Product List");

        TextField pName = new TextField("Product Name:");
        pName.setWidth("600px");

        NumberField pCost = new NumberField("Product Cost:");
        pCost.setValue((double) 0);
        pCost.setWidth("600px");

        NumberField pProfit = new NumberField("Product Profit:");
        pProfit.setValue((double) 0);
        pProfit.setWidth("600px");

        NumberField pPrice = new NumberField("Product Price:");
        pPrice.setValue((double) 0);
        pPrice.setWidth("600px");

        Button add = new Button("Add Product");
        Button update = new Button("Update Product");
        Button delete = new Button("Delete Product");
        Button clear = new Button("Clear Product");
        HorizontalLayout h1 = new HorizontalLayout();
        h1.add(add, update, delete, clear);
        add(pList, pName, pCost, pProfit, pPrice, h1);


    }
}
