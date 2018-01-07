package test;

import com.sun.istack.internal.Nullable;
import lsg.armor.ArmorItem;
import lsg.consumables.Consumable;
import lsg.weapons.Weapon;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class CharacterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void existCollectibleInterface() {
        try {
            Class<?> c = Class.forName("lsg.bags.Collectible");
            Method m = c.getDeclaredMethod("getWeight");

            Assert.assertEquals(m.getModifiers(), Modifier.PUBLIC | Modifier.ABSTRACT);
            Assert.assertTrue("wrong return type (int) of getWeight", m.getReturnType() == int.class);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have an interface called Collectible in lsg.bags package");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a method called getWeight in Collectible interface");
        }
    }

    @Test
    public void testCollectibleArmorItem() {
        try {
            Class<?> c = Class.forName("lsg.armor.ArmorItem");
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Method m = c.getDeclaredMethod("getWeight");

            Assert.assertTrue(i.isAssignableFrom(c));
            Assert.assertEquals(m.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (int) of getWeight", m.getReturnType() == int.class);

            Class<?> c2 = Class.forName("lsg.armor.RingedKnightArmor");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            Assert.assertEquals((int) (m.invoke(o2)), 4);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called lsg.armor.ArmorItem");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a method called getWeight in Collectible interface");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCollectibleWeapon() {
        try {
            Class<?> c = Class.forName("lsg.weapons.Weapon");
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Method m = c.getDeclaredMethod("getWeight");

            Assert.assertTrue(i.isAssignableFrom(c));
            Assert.assertEquals(m.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (int) of getWeight", m.getReturnType() == int.class);

            Class<?> c2 = Class.forName("lsg.weapons.Claw");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            Assert.assertEquals((int) (m.invoke(o2)), 2);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called lsg.weapon.Weapons");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a method called getWeight in Collectible interface");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCollectibleConsumable() {
        try {
            Class<?> c = Class.forName("lsg.consumables.Consumable");
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Method m = c.getDeclaredMethod("getWeight");

            Assert.assertTrue(i.isAssignableFrom(c));
            Assert.assertEquals(m.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (int) of getWeight", m.getReturnType() == int.class);

            Class<?> c2 = Class.forName("lsg.consumables.food.Americain");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            Assert.assertEquals((int) (m.invoke(o2)), 1);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called lsg.consumables.Consumable");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a method called getWeight in Collectible interface");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCollectibleBuffItem() {
        try {
            Class<?> c = Class.forName("lsg.buffs.BuffItem");
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Method m = c.getDeclaredMethod("getWeight");

            Assert.assertTrue(i.isAssignableFrom(c));
            Assert.assertEquals(m.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (int) of getWeight", m.getReturnType() == int.class);

            Class<?> c2 = Class.forName("lsg.buffs.rings.RingOfDeath");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            Assert.assertEquals((int) (m.invoke(o2)), 1);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called lsg.buffs.BuffItem");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a method called getWeight in Collectible interface");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCollectibleDragonSlayerLeggings() {
        try {
            Class<?> c = Class.forName("lsg.armor.DragonSlayerLeggings");
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Method m = c.getDeclaredMethod("getWeight");

            Assert.assertTrue(i.isAssignableFrom(c));
            Assert.assertEquals(m.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (int) of getWeight", m.getReturnType() == int.class);

            Class<?> c2 = Class.forName("lsg.armor.DragonSlayerLeggings");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            Assert.assertEquals((int) (m.invoke(o2)), 3);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called lsg.armor.DragonSlayerLeggings");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a method called getWeight in Collectible interface");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void existBagClass() {
        try {
            Class<?> c = Class.forName("lsg.bags.Bag");

            Assert.assertTrue(true);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called Bag in lsg.bags package");
        }
    }

    @Test
    public void testBagAttributes() {
        try {
            Class<?> c = Class.forName("lsg.bags.Bag");
            Field f1 = c.getDeclaredField("capacity");
            Field f2 = c.getDeclaredField("weight");
            Field f3 = c.getDeclaredField("items");

            Assert.assertEquals(f1.getModifiers(), Modifier.PRIVATE);
            Assert.assertEquals(f1.getType(), int.class);

            Assert.assertEquals(f2.getModifiers(), Modifier.PRIVATE);
            Assert.assertEquals(f2.getType(), int.class);

            Assert.assertEquals(f3.getModifiers(), Modifier.PRIVATE);
            Assert.assertEquals(f3.getType(), HashSet.class);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called Bag in lsg.bags package");
        } catch (NoSuchFieldException e) {
            Assert.fail("should have an attribute named capacity or weight or items");
        }
    }

    @Test
    public void testBagConstructorAndGetters() {
        try {
            Class<?> c = Class.forName("lsg.bags.Bag");
            Constructor<?> constructor = c.getDeclaredConstructor(int.class);
            Object o = constructor.newInstance(10);
            Method m1 = c.getDeclaredMethod("getWeight");
            Method m2 = c.getDeclaredMethod("getCapacity");

            Assert.assertEquals(m1.getModifiers(), Modifier.PUBLIC);
            Assert.assertEquals(m2.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (int) of getWeight", m1.getReturnType() == int.class);
            Assert.assertTrue("wrong return type (int) of getCapacity", m2.getReturnType() == int.class);

            Assert.assertEquals((int) (m1.invoke(o)), 0);
            Assert.assertEquals((int) (m2.invoke(o)), 10);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called Bag in lsg.bags package");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a constructor with one parameter called capacity");
        } catch (InstantiationException e) {
            Assert.assertTrue(false);
        } catch (IllegalAccessException e) {
            Assert.assertTrue(false);
        } catch (InvocationTargetException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void testBagPush() {
        try {
            Class<?> c = Class.forName("lsg.bags.Bag");
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Class<?> c3 = Class.forName("[Llsg.bags.Collectible;");
            Constructor<?> constructor = c.getDeclaredConstructor(int.class);
            Object o = constructor.newInstance(1);
            Method m1 = c.getDeclaredMethod("push", i);

            Assert.assertEquals(m1.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (void) of push", m1.getReturnType() == void.class);

            Class<?> c2 = Class.forName("lsg.consumables.food.Americain");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            m1.invoke(o, o2);

            Method m2 = c.getDeclaredMethod("getItems");

            Assert.assertEquals(m2.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (Collectible[]) of getItems", m2.getReturnType() == c3);

            Object o3 = m2.invoke(o);
            Assert.assertEquals(Array.getLength(o3), 1);

            Object o4 = constructor2.newInstance();
            m1.invoke(o, o4);
            o3 = m2.invoke(o);
            Assert.assertEquals(Array.getLength(o3), 1);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called Bag in lsg.bags package");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a method called push or getItems");
        } catch (InstantiationException e) {
            Assert.assertTrue(false);
        } catch (IllegalAccessException e) {
            Assert.assertTrue(false);
        } catch (InvocationTargetException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void testBagPop() {
        try {
            Class<?> c = Class.forName("lsg.bags.Bag");
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Class<?> c3 = Class.forName("[Llsg.bags.Collectible;");
            Constructor<?> constructor = c.getDeclaredConstructor(int.class);
            Object o = constructor.newInstance(1);
            Method m = c.getDeclaredMethod("push", i);
            Method m1 = c.getDeclaredMethod("pop", i);

            Assert.assertEquals(m1.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (void) of pop", m1.getReturnType() == i);

            Class<?> c2 = Class.forName("lsg.consumables.food.Americain");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            m.invoke(o, o2);

            Method m2 = c.getDeclaredMethod("getItems");

            Assert.assertEquals(m2.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (Collectible[]) of getItems", m2.getReturnType() == c3);

            Object o3 = m2.invoke(o);
            Assert.assertEquals(Array.getLength(o3), 1);

            Object o4 = m1.invoke(o, o2);

            Assert.assertEquals(o4.getClass(), c2);

            o3 = m2.invoke(o);
            Assert.assertEquals(Array.getLength(o3), 0);

            Object o5 = m1.invoke(o, o2);

            Assert.assertEquals(o5, null);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called Bag in lsg.bags package");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a method called push, pop or getItems");
        } catch (InstantiationException e) {
            Assert.assertTrue(false);
        } catch (IllegalAccessException e) {
            Assert.assertTrue(false);
        } catch (InvocationTargetException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void testBagContains() {
        try {
            Class<?> c = Class.forName("lsg.bags.Bag");
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Constructor<?> constructor = c.getDeclaredConstructor(int.class);
            Object o = constructor.newInstance(1);
            Method m = c.getDeclaredMethod("push", i);
            Method m1 = c.getDeclaredMethod("contains", i);

            Assert.assertEquals(m1.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (bool) of contains", m1.getReturnType() == boolean.class);

            Class<?> c2 = Class.forName("lsg.consumables.food.Americain");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            m.invoke(o, o2);

            Assert.assertEquals((boolean) (m1.invoke(o, o2)), true);

            Object o3 = constructor2.newInstance();

            Assert.assertEquals((boolean) (m1.invoke(o, o3)), false);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called Bag in lsg.bags package");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a method called push or contains");
        } catch (InstantiationException e) {
            Assert.assertTrue(false);
        } catch (IllegalAccessException e) {
            Assert.assertTrue(false);
        } catch (InvocationTargetException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void testBagToString() {
        try {
            Class<?> c = Class.forName("lsg.bags.Bag");
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Constructor<?> constructor = c.getDeclaredConstructor(int.class);
            Object o = constructor.newInstance(10);
            Method m = c.getDeclaredMethod("push", i);
            Method m1 = c.getDeclaredMethod("toString");

            Assert.assertEquals(m1.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (String) of toString", m1.getReturnType() == String.class);

            Assert.assertEquals((String) (m1.invoke(o)), "Bag [ 0 items | 0/10 kg ]\n" +
                    "∙ (empty)");

            Class<?> c2 = Class.forName("lsg.weapons.ShotGun");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            m.invoke(o, o2);

            Class<?> c3 = Class.forName("lsg.armor.DragonSlayerLeggings");
            Constructor<?> constructor3 = c3.getDeclaredConstructor();
            Object o3 = constructor3.newInstance();

            m.invoke(o, o3);

            Class<?> c4 = Class.forName("lsg.armor.RingedKnightArmor");
            Constructor<?> constructor4 = c4.getDeclaredConstructor();
            Object o4 = constructor4.newInstance();

            m.invoke(o, o4);

            String[] list = ((String) (m1.invoke(o))).split("\n");
            String[] list2 = Arrays.copyOfRange(list, 1, 5);

            Assert.assertEquals(list[0], "Bag [ 3 items | 9/10 kg ]");
            Assert.assertTrue(Arrays.asList(list2).contains("∙ ShotGun (min:6 max:20 stam:5 dur:100)[2 kg]"));
            Assert.assertTrue(Arrays.asList(list2).contains("∙ Dragon Slayer Leggings(10.2)[3 kg]"));
            Assert.assertTrue(Arrays.asList(list2).contains("∙ Ringed Knight Armor(14.99)[4 kg]"));
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called Bag in lsg.bags package");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a method called push or toString");
        } catch (InstantiationException e) {
            Assert.assertTrue(false);
        } catch (IllegalAccessException e) {
            Assert.assertTrue(false);
        } catch (InvocationTargetException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void existSmallBagClass() {
        try {
            Class<?> c = Class.forName("lsg.bags.SmallBag");

            Constructor<?> constructor = c.getDeclaredConstructor();
            Object o = constructor.newInstance();
            Method m = c.getMethod("getCapacity");

            Assert.assertEquals((int) (m.invoke(o)), 10);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called SmallBag in lsg.bags package");
        } catch (NoSuchMethodException e) {
            Assert.assertTrue(false);
        } catch (InstantiationException e) {
            Assert.assertTrue(false);
        } catch (IllegalAccessException e) {
            Assert.assertTrue(false);
        } catch (InvocationTargetException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void existMediumBagClass() {
        try {
            Class<?> c = Class.forName("lsg.bags.MediumBag");

            Constructor<?> constructor = c.getDeclaredConstructor();
            Object o = constructor.newInstance();
            Method m = c.getMethod("getCapacity");

            Assert.assertEquals((int) (m.invoke(o)), 40);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called MediumBag in lsg.bags package");
        } catch (NoSuchMethodException e) {
            Assert.assertTrue(false);
        } catch (InstantiationException e) {
            Assert.assertTrue(false);
        } catch (IllegalAccessException e) {
            Assert.assertTrue(false);
        } catch (InvocationTargetException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void testBagMain() {
        try {
            Class<?> c = Class.forName("lsg.bags.SmallBag");
            Method m = c.getMethod("main", String[].class);
            Object[] args = new Object[1];

            args[0] = new String[]{};
            m.invoke(null, args);

            String[] list = outContent.toString().split("\n");

            Assert.assertEquals("SmallBag [ 4 items | 10/10 kg ]", list[0]);

            String[] list2 = Arrays.copyOfRange(list, 1, 5);

            Assert.assertTrue(Arrays.asList(list2).contains("∙ Black Witch Veil(4.6)[4 kg]"));
            Assert.assertTrue(Arrays.asList(list2).contains("∙ Dragon Slayer Leggings(10.2)[3 kg]"));
            Assert.assertTrue(Arrays.asList(list2).contains("∙ Basic Sword (min:5 max:10 stam:20 dur:100)[2 kg]"));
            Assert.assertTrue(Arrays.asList(list2).contains("∙ Uncle Greg's spicy Maroilles burger [40 life point(s)][1 kg]"));

            Assert.assertEquals("Pop sur Dragon Slayer Leggings(10.2)", list[6]);
            Assert.assertEquals("", list[7]);
            Assert.assertEquals("SmallBag [ 3 items | 7/10 kg ]", list[8]);

            String[] list3 = Arrays.copyOfRange(list, 9, 12);

            Assert.assertTrue(Arrays.asList(list3).contains("∙ Black Witch Veil(4.6)[4 kg]"));
            Assert.assertTrue(Arrays.asList(list3).contains("∙ Basic Sword (min:5 max:10 stam:20 dur:100)[2 kg]"));
            Assert.assertTrue(Arrays.asList(list3).contains("∙ Uncle Greg's spicy Maroilles burger [40 life point(s)][1 kg]"));
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called MediumBag in lsg.bags package");
        } catch (NoSuchMethodException e) {
            Assert.assertTrue(false);
        } catch (IllegalAccessException e) {
            Assert.assertTrue(false);
        } catch (InvocationTargetException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void testTransfer() {
        try {
            Class<?> c = Class.forName("lsg.bags.Bag");
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Constructor<?> constructor = c.getDeclaredConstructor(int.class);
            Object b1 = constructor.newInstance(10);
            Object b2 = constructor.newInstance(5);
            Method m1 = c.getDeclaredMethod("push", i);
            Method m = c.getDeclaredMethod("transfer", c, c);

            Assert.assertEquals(m.getModifiers(), Modifier.PUBLIC | Modifier.STATIC);
            Assert.assertTrue("wrong return type (void) of transfer", m.getReturnType() == void.class);

            Class<?> c2 = Class.forName("lsg.weapons.ShotGun");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            m1.invoke(b1, o2);

            Class<?> c3 = Class.forName("lsg.armor.DragonSlayerLeggings");
            Constructor<?> constructor3 = c3.getDeclaredConstructor();
            Object o3 = constructor3.newInstance();

            m1.invoke(b1, o3);

            Class<?> c4 = Class.forName("lsg.armor.RingedKnightArmor");
            Constructor<?> constructor4 = c4.getDeclaredConstructor();
            Object o4 = constructor4.newInstance();

            m1.invoke(b1, o4);

            m.invoke(null, b1, b2);

            Method m2 = c.getDeclaredMethod("getItems");

            Object o5 = m2.invoke(b1);
            Object o6 = m2.invoke(b2);
            Assert.assertEquals(Array.getLength(o5) + Array.getLength(o6), 3);

            Method m3 = c.getDeclaredMethod("getCapacity");
            Method m4 = c.getDeclaredMethod("getWeight");

            Assert.assertTrue((int) (m3.invoke(b1)) >= (int) (m4.invoke(b1)));
            Assert.assertTrue((int) (m3.invoke(b2)) >= (int) (m4.invoke(b2)));

        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called lsg.bags.Bag");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a method called transfer in Bag class");
        } catch (IllegalAccessException e) {
            Assert.assertTrue(false);
        } catch (InvocationTargetException e) {
            Assert.assertTrue(false);
        } catch (InstantiationException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void testTransferWithMain() {
        try {
            Class<?> c = Class.forName("lsg.bags.Bag");
            Method m = c.getDeclaredMethod("transfer", c, c);

            Assert.assertEquals(m.getModifiers(), Modifier.PUBLIC | Modifier.STATIC);
            Assert.assertTrue("wrong return type (void) of transfer", m.getReturnType() == void.class);

            Method m2 = c.getMethod("main", String[].class);
            Object[] args = new Object[1];

            args[0] = new String[]{};
            m2.invoke(null, args);

            String[] list = outContent.toString().split("\n");

            Assert.assertEquals("Sac 1 :", list[0]);
            Assert.assertEquals("Bag [ 3 items | 9/10 kg ]", list[1]);

            String[] list2 = Arrays.copyOfRange(list, 2, 5);

            Assert.assertTrue(Arrays.asList(list2).contains("∙ Ringed Knight Armor(14.99)[4 kg]"));
            Assert.assertTrue(Arrays.asList(list2).contains("∙ Dragon Slayer Leggings(10.2)[3 kg]"));
            Assert.assertTrue(Arrays.asList(list2).contains("∙ ShotGun (min:6 max:20 stam:5 dur:100)[2 kg]"));

            Assert.assertEquals("Sac 2 :", list[6]);
            Assert.assertEquals("Bag [ 0 items | 0/5 kg ]", list[7]);
            Assert.assertEquals("∙ (empty)", list[8]);
            Assert.assertEquals("", list[9]);
            Assert.assertEquals("Sac 2 après transfert :", list[10]);
            Assert.assertTrue(list[11].contentEquals("Bag [ 1 items | 4/5 kg ]") || list[11].contentEquals("Bag [ 2 items | 5/5 kg ]"));
            Assert.assertEquals("∙ Ringed Knight Armor(14.99)[4 kg]", list[12]);
            Assert.assertEquals("", list[13]);
            Assert.assertEquals("Sac 1 après transfert :", list[14]);
            Assert.assertEquals("Bag [ 2 items | 5/10 kg ]", list[15]);
            Assert.assertEquals("∙ Dragon Slayer Leggings(10.2)[3 kg]", list[16]);
            Assert.assertEquals("∙ ShotGun (min:6 max:20 stam:5 dur:100)[2 kg]", list[17]);

        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called lsg.bags.Bag");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have a method called transfer in Bag class");
        } catch (IllegalAccessException e) {
            Assert.assertTrue(false);
        } catch (InvocationTargetException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void testBagAttributeInCharacterClass() {
        try {
            Class<?> c1 = Class.forName("lsg.bags.Bag");
            Class<?> c2 = Class.forName("lsg.characters.Character");
            Class<?> c3 = Class.forName("lsg.bags.SmallBag");
            Class<?> c4 = Class.forName("lsg.characters.Hero");
            Field f = c2.getDeclaredField("bag");
            Constructor<?> constructor = c4.getDeclaredConstructor();
            Object o = constructor.newInstance();

            Assert.assertEquals(f.getModifiers(), Modifier.PRIVATE);
            Assert.assertEquals(f.getType(), c1);

            f.setAccessible(true);
            Assert.assertEquals(f.get(o).getClass(), c3);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called Bag ou SmallBag in lsg.bags package");
        } catch (NoSuchFieldException e) {
            Assert.fail("should have an attribute named bag in Character class");
        } catch (NoSuchMethodException e) {
            Assert.assertTrue(false);
        } catch (InstantiationException e) {
            Assert.assertTrue(false);
        } catch (IllegalAccessException e) {
            Assert.assertTrue(false);
        } catch (InvocationTargetException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void testPickUp() {
        try {
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Class<?> c = Class.forName("lsg.characters.Hero");
            Class<?> c1 = Class.forName("lsg.characters.Character");
            Method m = c1.getDeclaredMethod("pickUp", i);

            Constructor<?> constructor = c.getDeclaredConstructor();
            Object o = constructor.newInstance();

            Assert.assertEquals(m.getModifiers(), Modifier.PUBLIC);
            Assert.assertEquals(m.getReturnType(), void.class);

            Class<?> c2 = Class.forName("lsg.armor.DragonSlayerLeggings");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            m.invoke(o, o2);
            Assert.assertEquals(outContent.toString(), "Gregooninator picks up Dragon Slayer Leggings(10.2)");
        } catch (ClassNotFoundException e) {
            Assert.fail("should have an interface called Collectible");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have an method named pickUp in Character class");
        } catch (InstantiationException e) {
            Assert.assertTrue(false);
        } catch (IllegalAccessException e) {
            Assert.assertTrue(false);
        } catch (InvocationTargetException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void testPullOut() {
        try {
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Class<?> c = Class.forName("lsg.characters.Hero");
            Class<?> c1 = Class.forName("lsg.characters.Character");
            Method m = c1.getDeclaredMethod("pullOut", i);
            Method m2 = c1.getDeclaredMethod("pickUp", i);

            Constructor<?> constructor = c.getDeclaredConstructor();
            Object o = constructor.newInstance();

            Assert.assertEquals(m.getModifiers(), Modifier.PUBLIC);
            Assert.assertEquals(m.getReturnType(), i);

            Class<?> c2 = Class.forName("lsg.consumables.food.Hamburger");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            m2.invoke(o, o2);
            m.invoke(o, o2);
            Assert.assertEquals(outContent.toString(), "Gregooninator picks up Uncle Greg's spicy Maroilles burger [40 life point(s)]Gregooninator pulls out Uncle Greg's spicy Maroilles burger [40 life point(s)]");
        } catch (ClassNotFoundException e) {
            Assert.fail("should have an interface called Collectible");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have an method named pullOut or pickUp in Character class");
        } catch (InstantiationException e) {
            Assert.assertTrue(false);
        } catch (IllegalAccessException e) {
            Assert.assertTrue(false);
        } catch (InvocationTargetException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void testPrintBag() {
        try {
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Class<?> c = Class.forName("lsg.characters.Hero");
            Class<?> c1 = Class.forName("lsg.characters.Character");
            Method m = c1.getDeclaredMethod("pickUp", i);
            Method m1 = c1.getDeclaredMethod("printBag");
            Constructor<?> constructor = c.getDeclaredConstructor();
            Object o = constructor.newInstance();

            Assert.assertEquals(m1.getModifiers(), Modifier.PUBLIC);
            Assert.assertEquals(m1.getReturnType(), void.class);

            Class<?> c2 = Class.forName("lsg.armor.DragonSlayerLeggings");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            m.invoke(o, o2);

            Class<?> c3 = Class.forName("lsg.weapons.ShotGun");
            Constructor<?> constructor3 = c3.getDeclaredConstructor();
            Object o3 = constructor3.newInstance();

            m.invoke(o, o3);

            Class<?> c4 = Class.forName("lsg.armor.RingedKnightArmor");
            Constructor<?> constructor4 = c4.getDeclaredConstructor();
            Object o4 = constructor4.newInstance();

            m.invoke(o, o4);

            System.out.println();

            m1.invoke(o);

            String[] list = outContent.toString().split("\n");

            Assert.assertEquals("BAG : SmallBag [ 3 items | 9/10 kg ]", list[1]);

            String[] list2 = Arrays.copyOfRange(list, 2, 5);

            Assert.assertTrue(Arrays.asList(list2).contains("∙ Ringed Knight Armor(14.99)[4 kg]"));
            Assert.assertTrue(Arrays.asList(list2).contains("∙ Dragon Slayer Leggings(10.2)[3 kg]"));
            Assert.assertTrue(Arrays.asList(list2).contains("∙ ShotGun (min:6 max:20 stam:5 dur:100)[2 kg]"));
        } catch (ClassNotFoundException e) {
            Assert.fail("should have an interface called Collectible");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have an method named pickUp in Character class");
        } catch (InstantiationException e) {
            Assert.assertTrue(false);
        } catch (IllegalAccessException e) {
            Assert.assertTrue(false);
        } catch (InvocationTargetException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void existGetBagCapacity() {
        try {
            Class<?> c = Class.forName("lsg.characters.Character");
            Method m = c.getDeclaredMethod("getBagCapacity");

            Assert.assertEquals(m.getModifiers(), Modifier.PUBLIC);
            Assert.assertEquals(m.getReturnType(), int.class);

        } catch (ClassNotFoundException e) {
            Assert.fail("should have an interface called Character");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have an method named getBagCapacity in Character class");
        }
    }

    @Test
    public void existGetBagWeight() {
        try {
            Class<?> c = Class.forName("lsg.characters.Character");
            Method m = c.getDeclaredMethod("getBagWeight");

            Assert.assertEquals(m.getModifiers(), Modifier.PUBLIC);
            Assert.assertEquals(m.getReturnType(), int.class);

        } catch (ClassNotFoundException e) {
            Assert.fail("should have an interface called Character");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have an method named getBagWeight in Character class");
        }
    }

    @Test
    public void existGetBagItems() {
        try {
            Class<?> c = Class.forName("lsg.characters.Character");
            Method m = c.getDeclaredMethod("getBagItems");
            Class<?> c3 = Class.forName("[Llsg.bags.Collectible;");

            Assert.assertEquals(m.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (Collectible[]) of getBagItems", m.getReturnType() == c3);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have an interface called Character");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have an method named getBagWeight in Character class");
        }
    }

    @Test
    public void testSetBag() {
        try {
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Class<?> c = Class.forName("lsg.characters.Hero");
            Class<?> c1 = Class.forName("lsg.characters.Character");
            Class<?> cb = Class.forName("lsg.bags.Bag");
            Method m = c1.getDeclaredMethod("setBag", cb);
            Method m2 = c1.getDeclaredMethod("pickUp", i);
            Constructor<?> constructor = c.getDeclaredConstructor();
            Object o = constructor.newInstance();

            Assert.assertEquals(m.getModifiers(), Modifier.PUBLIC);
            Assert.assertEquals(m.getReturnType(), cb);

            Class<?> c2 = Class.forName("lsg.armor.DragonSlayerLeggings");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            m2.invoke(o, o2);

            Class<?> c3 = Class.forName("lsg.weapons.ShotGun");
            Constructor<?> constructor3 = c3.getDeclaredConstructor();
            Object o3 = constructor3.newInstance();

            m2.invoke(o, o3);

            Class<?> c4 = Class.forName("lsg.armor.RingedKnightArmor");
            Constructor<?> constructor4 = c4.getDeclaredConstructor();
            Object o4 = constructor4.newInstance();

            m2.invoke(o, o4);

            Class<?> c5 = Class.forName("lsg.bags.MediumBag");
            Constructor<?> constructor5 = c5.getDeclaredConstructor();
            Object o5 = constructor5.newInstance();

            System.out.println();

            Object o6 = m.invoke(o, o5);

            Class<?> c6 = Class.forName("lsg.bags.SmallBag");
            Method m4 = c6.getMethod("getWeight");

            Assert.assertEquals(o6.getClass(), c6);
            Assert.assertEquals((int)(m4.invoke(o6)), 0);

            Method m3 = c1.getDeclaredMethod("printBag");

            m3.invoke(o);

            String[] list = outContent.toString().split("\n");

            Assert.assertEquals(list[1], "Gregooninator changes SmallBag for MediumBag");
            Assert.assertEquals(list[2], "BAG : MediumBag [ 3 items | 9/40 kg ]");

            String[] list2 = Arrays.copyOfRange(list, 3, 6);

            Assert.assertTrue(Arrays.asList(list2).contains("∙ Ringed Knight Armor(14.99)[4 kg]"));
            Assert.assertTrue(Arrays.asList(list2).contains("∙ Dragon Slayer Leggings(10.2)[3 kg]"));
            Assert.assertTrue(Arrays.asList(list2).contains("∙ ShotGun (min:6 max:20 stam:5 dur:100)[2 kg]"));
        } catch (ClassNotFoundException e) {
            Assert.fail("should have an interface called Collectible");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have an method named SetBag in Character class");
        } catch (InstantiationException e) {
            Assert.assertTrue(false);
        } catch (IllegalAccessException e) {
            Assert.assertTrue(false);
        } catch (InvocationTargetException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void testEquip() {
        try {
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Class<?> c = Class.forName("lsg.characters.Hero");
            Class<?> c1 = Class.forName("lsg.characters.Character");
            Class<?> cw = Class.forName("lsg.weapons.Weapon");
            Class<?> cc = Class.forName("lsg.consumables.Consumable");
            Method m1 = c1.getDeclaredMethod("equip", cw);
            Method m2 = c1.getDeclaredMethod("equip", cc);
            Method m3 = c1.getDeclaredMethod("pickUp", i);

            Assert.assertEquals(m1.getModifiers(), Modifier.PUBLIC);
            Assert.assertEquals(m1.getReturnType(), void.class);
            Assert.assertEquals(m2.getModifiers(), Modifier.PUBLIC);
            Assert.assertEquals(m2.getReturnType(), void.class);

            Constructor<?> constructor = c.getDeclaredConstructor();
            Object o = constructor.newInstance();

            Class<?> c2 = Class.forName("lsg.armor.DragonSlayerLeggings");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            m3.invoke(o, o2);

            Class<?> c3 = Class.forName("lsg.weapons.ShotGun");
            Constructor<?> constructor3 = c3.getDeclaredConstructor();
            Object o3 = constructor3.newInstance();

            m3.invoke(o, o3);

            Class<?> c4 = Class.forName("lsg.consumables.food.Hamburger");
            Constructor<?> constructor4 = c4.getDeclaredConstructor();
            Object o4 = constructor4.newInstance();

            m3.invoke(o, o4);

            System.out.println();

            m1.invoke(o, o3);

            Method m4 = c1.getDeclaredMethod("getWeapon");
            Object o5 = m4.invoke(o);

            Assert.assertEquals(o5, o3);

            m2.invoke(o, o4);

            Method m5 = c1.getDeclaredMethod("getConsumable");
            Object o6 = m5.invoke(o);

            Assert.assertEquals(o6, o4);

            String[] list = outContent.toString().split("\n");

            Assert.assertEquals(list[1], "Gregooninator pulls out ShotGun (min:6 max:20 stam:5 dur:100) and equips it !");
            Assert.assertEquals(list[2], "Gregooninator pulls out Uncle Greg's spicy Maroilles burger [40 life point(s)] and equips it !");
        } catch (ClassNotFoundException e) {
            Assert.fail("should have an interface called Collectible");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have an method named equip in Character class");
        } catch (InstantiationException e) {
            Assert.assertTrue(false);
        } catch (IllegalAccessException e) {
            Assert.assertTrue(false);
        } catch (InvocationTargetException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void testEquipInHero() {
        try {
            Class<?> i = Class.forName("lsg.bags.Collectible");
            Class<?> c = Class.forName("lsg.characters.Hero");
            Class<?> c1 = Class.forName("lsg.characters.Character");
            Class<?> ca = Class.forName("lsg.armor.ArmorItem");
            Class<?> cr = Class.forName("lsg.buffs.rings.Ring");
            Method m1 = c.getDeclaredMethod("equip", ca, int.class);
            Method m2 = c.getDeclaredMethod("equip", cr, int.class);
            Method m3 = c1.getDeclaredMethod("pickUp", i);

            Assert.assertEquals(m1.getModifiers(), Modifier.PUBLIC);
            Assert.assertEquals(m1.getReturnType(), void.class);
            Assert.assertEquals(m2.getModifiers(), Modifier.PUBLIC);
            Assert.assertEquals(m2.getReturnType(), void.class);

            Constructor<?> constructor = c.getDeclaredConstructor();
            Object o = constructor.newInstance();

            Class<?> c2 = Class.forName("lsg.armor.DragonSlayerLeggings");
            Constructor<?> constructor2 = c2.getDeclaredConstructor();
            Object o2 = constructor2.newInstance();

            m3.invoke(o, o2);
            System.out.println();

            Class<?> c3 = Class.forName("lsg.armor.BlackWitchVeil");
            Constructor<?> constructor3 = c3.getDeclaredConstructor();
            Object o3 = constructor3.newInstance();

            m3.invoke(o, o3);
            System.out.println();

            Class<?> c4 = Class.forName("lsg.buffs.rings.RingOfDeath");
            Constructor<?> constructor4 = c4.getDeclaredConstructor();
            Object o4 = constructor4.newInstance();

            m3.invoke(o, o4);
            System.out.println();

            m1.invoke(o, o2, 1);
            m1.invoke(o, o3, 2);
            m2.invoke(o, o4, 1);

            String[] list = outContent.toString().split("\n");

            Assert.assertEquals(list[0], "Gregooninator picks up Dragon Slayer Leggings(10.2)");
            Assert.assertEquals(list[1], "Gregooninator picks up Black Witch Veil(4.6)");
            Assert.assertEquals(list[2], "Gregooninator picks up [Ring of Death, 0.00]");
            Assert.assertEquals(list[3], "Gregooninator pulls out Dragon Slayer Leggings(10.2) and equips it !");
            Assert.assertEquals(list[4], "Gregooninator pulls out Black Witch Veil(4.6) and equips it !");
            Assert.assertEquals(list[5], "Gregooninator pulls out [Ring of Death, 0.00] and equips it !");
        } catch (ClassNotFoundException e) {
            Assert.fail("should have an interface called Collectible");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have an method named equip in Hero class");
        } catch (IllegalAccessException e) {
            Assert.assertTrue(false);
        } catch (InstantiationException e) {
            Assert.assertTrue(false);
        } catch (InvocationTargetException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void existFastUseFirst() {
        try {
            Class<?> c1 = Class.forName("lsg.characters.Character");
            Class<?> c2 = Class.forName("lsg.consumables.Consumable");
            Method m1 = c1.getDeclaredMethod("fastUseFirst", Class.class);

            Assert.assertEquals(m1.getModifiers(), Modifier.PRIVATE);
            Assert.assertTrue("wrong return type (Consumable) of fastUseFirst", m1.getReturnType() == c2);
            Assert.assertEquals(m1.getGenericParameterTypes()[0].getTypeName(), "java.lang.Class<? extends lsg.consumables.Consumable>");
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called Character");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have an method named fastUseFirst in Character class");
        }
    }

    @Test
    public void testFastUseFirst() {
        try {
            Class<?> c1 = Class.forName("lsg.characters.Character");
            Class<?> cc = Class.forName("lsg.consumables.Consumable");
            Method m1 = c1.getDeclaredMethod("fastUseFirst", Class.class);

            Class<?> i = Class.forName("lsg.bags.Collectible");
            Class<?> c3 = Class.forName("lsg.characters.Hero");
            Method m2 = c1.getDeclaredMethod("pickUp", i);
            Constructor<?> constructor = c3.getDeclaredConstructor();
            Object o = constructor.newInstance();
            Method m3 = c1.getDeclaredMethod("getBagItems");

            Class<?> c4 = Class.forName("lsg.consumables.food.Hamburger");
            Constructor<?> constructor4 = c4.getDeclaredConstructor();
            Object o4 = constructor4.newInstance();

            m1.setAccessible(true);
            m2.invoke(o, o4);

            Object o5 = m3.invoke(o);

            Assert.assertEquals(Array.getLength(o5), 1);

            Class<?> c5 = Class.forName("lsg.consumables.food.Food");

            Assert.assertEquals(m1.invoke(o, c5), o4);

            Class<?> c6 = Class.forName("lsg.consumables.drinks.Drink");

            Assert.assertEquals(m1.invoke(o, c6), null);

            Object o6 = m3.invoke(o);

            Assert.assertEquals(Array.getLength(o6), 0);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called Character");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have an method named fastUseFirst in Character class");
        } catch (IllegalAccessException e) {
            Assert.assertTrue(false);
        } catch (InstantiationException e) {
            Assert.assertTrue(false);
        } catch (InvocationTargetException e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void existFastMethods() {
        try {
            Class<?> c1 = Class.forName("lsg.characters.Character");
            Class<?> c2 = Class.forName("lsg.consumables.drinks.Drink");
            Class<?> c3 = Class.forName("lsg.consumables.food.Food");
            Class<?> c4 = Class.forName("lsg.consumables.repair.RepairKit");
            Method m1 = c1.getDeclaredMethod("fastDrink");
            Method m2 = c1.getDeclaredMethod("fastEat");
            Method m3 = c1.getDeclaredMethod("fastRepair");

            Assert.assertEquals(m1.getModifiers(), Modifier.PUBLIC);
            Assert.assertEquals(m2.getModifiers(), Modifier.PUBLIC);
            Assert.assertEquals(m3.getModifiers(), Modifier.PUBLIC);
            Assert.assertTrue("wrong return type (Drink) of fastDrink", m1.getReturnType() == c2);
            Assert.assertTrue("wrong return type (Food) of fastEat", m2.getReturnType() == c3);
            Assert.assertTrue("wrong return type (RepairKit) of fastRepair", m3.getReturnType() == c4);

            Class<?> i = Class.forName("lsg.bags.Collectible");
            Class<?> c5 = Class.forName("lsg.characters.Hero");
            Method m4 = c1.getDeclaredMethod("pickUp", i);
            Constructor<?> constructor = c5.getDeclaredConstructor();
            Object o = constructor.newInstance();

            Class<?> c6 = Class.forName("lsg.consumables.food.Hamburger");
            Constructor<?> constructor6 = c6.getDeclaredConstructor();
            Object o4 = constructor6.newInstance();

            m4.invoke(o, o4);

            System.out.println("");

            Object o5 = m2.invoke(o);

            Assert.assertTrue(o5 == o4);

            String[] list = outContent.toString().split("\n");

            Assert.assertEquals(list[0], "Gregooninator picks up Uncle Greg's spicy Maroilles burger [40 life point(s)]");
            Assert.assertEquals(list[1], "Gregooninator eats FAST :");
            Assert.assertEquals(list[2], "Gregooninator eats Uncle Greg's spicy Maroilles burger [40 life point(s)]");
            Assert.assertEquals(list[3], "Gregooninator pulls out Uncle Greg's spicy Maroilles burger [0 life point(s)]");

            Object o6 = m1.invoke(o);

            Assert.assertEquals(o6, null);
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called Character");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have an method named fastDrink ou fastEat or fastRepair in Character class");
        } catch (IllegalAccessException e) {
            Assert.assertTrue(false);
        } catch (InstantiationException e) {
            Assert.assertTrue(false);
        } catch (InvocationTargetException e) {
            Assert.assertTrue(false);
        }
    }


}