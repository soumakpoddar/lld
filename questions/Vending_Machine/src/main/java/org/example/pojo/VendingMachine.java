package org.example.pojo;

import lombok.Data;
import org.example.state.IState;
import org.example.state.impl.IdleState;

import java.util.ArrayList;
import java.util.List;

@Data
public class VendingMachine {
    private IState state;
    private Inventory inventory;
    private List<Coin> coins;

    public VendingMachine() {
        state = new IdleState();
        inventory = new Inventory(10);
        coins = new ArrayList<>();
    }
}
