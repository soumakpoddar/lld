package org.example.pojo;

import lombok.Data;
import org.example.AtmStates.AtmState;
import org.example.AtmStates.IdleState;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class Atm {
    private AtmState state;
    private BigDecimal totalBalance;

    public Atm() {
        this.state = new IdleState();
        this.totalBalance = BigDecimal.ZERO;
    }
}
