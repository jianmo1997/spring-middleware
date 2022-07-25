package org.jianmo.springmiddleware.design.mediator;

/**
 * 中介者模式
 */
public class Client {

  public static void main(String[] args) {

    // 一个房主、一个租客、一个中介
    MediatorStructure mediator = new MediatorStructure();

    // 房主和租房者只需要中介机构即可
    HouseOwner houseOwner = new HouseOwner("张三" , mediator);
    Tenant tenant = new Tenant("李四" , mediator);

    // 中介要知道租客和房主
    mediator.setHouseOwner(houseOwner);
    mediator.setTenant(tenant);

    tenant.constact("租客");
    houseOwner.constact("房东");

  }

}
