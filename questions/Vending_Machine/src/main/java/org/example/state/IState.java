package org.example.state;

import org.example.pojo.Coin;
import org.example.pojo.Item;
import org.example.pojo.VendingMachine;

import java.util.List;

public interface IState {
    void clickOnCoinInsertButton(VendingMachine vendingMachine) throws Exception;
    void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception;
    void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception;
    void chooseProduct(VendingMachine vendingMachine, int productCode) throws Exception;
    int getChange(int returnChangeMoney) throws Exception;
    Item dispenseProduct(VendingMachine vendingMachine, int productCode) throws Exception;
    List<Coin> refundFullMoney(VendingMachine machine) throws Exception;
    void updateInventory(VendingMachine machine, Item item, int productCode) throws Exception;
}
