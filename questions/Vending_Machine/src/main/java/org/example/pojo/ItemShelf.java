package org.example.pojo;

import lombok.Data;

@Data
public class ItemShelf {
    private int code;
    private Item item;
    private boolean soldOut;
}
