package src;

import static org.junit.jupiter.api.Assertions.*;

class NvectorTest {

  @org.junit.jupiter.api.Test
  void VARARGNvector(){
    Nvector testvec = new Nvector(5,6,2,1,2,3,23.9,8.76);
    double controlvec[] = {5,6,2,1,2,3,23.9,8.76};
    for(int i = 0; i < testvec.length();i++){
      assertEquals(controlvec[i], testvec.get(i));
    }
  }


  @org.junit.jupiter.api.Test
  void get() {
    Nvector testvec = new Nvector(3,4,1,2);
    assertEquals(4, testvec.get(1));
  }

  @org.junit.jupiter.api.Test
  void isEqual() {
    Nvector testvec = new Nvector(3,4,1,2);
    Nvector testvec2 = new Nvector(3,4,1,2);
    assertEquals(true, testvec.isEqual(testvec2));
  }

  @org.junit.jupiter.api.Test
  void add() {
    Nvector testvec = new Nvector(3,4,1,2);
    Nvector testvec2 = new Nvector(3,4,1,2);
    assertEquals( "[6.0,8.0,2.0,4.0]", testvec.add(testvec2).toString());
  }

  @org.junit.jupiter.api.Test
  void sprod() {
    Nvector testvec = new Nvector(3,4,1,2);
    Nvector testvec2 = new Nvector(3,4,1,2);
    assertEquals(30, testvec.sprod(testvec2));
  }

  @org.junit.jupiter.api.Test
  void NvectoString() {
    Nvector testvec = new Nvector(3,4,1,2);
    Nvector testvec2 = new Nvector(3,4,1,2);
    assertEquals("[3.0,4.0,1.0,2.0]", testvec.toString());
  }
}