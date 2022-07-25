package org.jianmo.springmiddleware.design.mediator;

/**
 *
 *  中介者类
 */
public class MediatorStructure extends Mediator{
  // 首先中介结构必须知道所有房主和租房族信息
  private HouseOwner houseOwner;

  private Tenant tenant;

  public HouseOwner getHouseOwner(){
    return houseOwner;
  }

  public void setHouseOwner(HouseOwner houseOwner) {
    this.houseOwner = houseOwner;
  }

  public void setTenant(Tenant tenant) {
    this.tenant = tenant;
  }

  public Tenant getTenant() {
    return tenant;
  }

  @Override
  public void constact(String message, Person person) {

    if (person == houseOwner){
      tenant.getMessage(message);
    } else {
      houseOwner.getMessage(message);
    }
  }
}
