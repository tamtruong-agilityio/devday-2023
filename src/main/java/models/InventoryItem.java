package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class InventoryItem {

    private String name;
    private int index;
    private float price;
    private String description;

    public InventoryItem(Map<String, String> data) {
        this.name = data.get("Name") != null ? data.get("Name") : "";
        this.index = data.get("Index") != null ? Integer.parseInt(data.get("Index")) : 1;
        this.price = data.get("Price") != null ? Float.parseFloat(data.get("Price")) : 0;
        this.description = data.get("Description") != null ? data.get("Description") : "";
    }
}
