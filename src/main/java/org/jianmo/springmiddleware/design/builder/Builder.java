package org.jianmo.springmiddleware.design.builder;

import org.jianmo.springmiddleware.design.builder.ceilling.LevelOneCeiling;
import org.jianmo.springmiddleware.design.builder.ceilling.LevelTwoCeiling;
import org.jianmo.springmiddleware.design.builder.coat.DuluxCoat;
import org.jianmo.springmiddleware.design.builder.coat.LiBangCoat;
import org.jianmo.springmiddleware.design.builder.floor.ShengXiangFloor;
import org.jianmo.springmiddleware.design.builder.tile.DongPengTile;
import org.jianmo.springmiddleware.design.builder.tile.MarcoPoloTile;

public class Builder {

  public IMenu levelOne(Double area) {
    return new DecorationPackageMenu(area, "豪华欧式")
        .appendCeiling(new LevelTwoCeiling())
        .appendCoat(new DuluxCoat())
        .appendFloor(new ShengXiangFloor());

  }


  public IMenu levelTwo(Double area){
    return new DecorationPackageMenu(area, "轻奢田园")
        .appendCeiling(new LevelTwoCeiling())
        .appendCoat(new LiBangCoat())
        .appendTile(new MarcoPoloTile());

  }

  public IMenu levelThree(Double area){
    return new DecorationPackageMenu(area, "现代简约")
        .appendCeiling(new LevelOneCeiling())
        .appendCoat(new LiBangCoat())
        .appendTile(new DongPengTile());
  }

}
