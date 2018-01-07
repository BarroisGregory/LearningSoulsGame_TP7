package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.*;
import java.util.Arrays;

public class LearningSoulsGameTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final ByteArrayInputStream in = new ByteArrayInputStream("1\n2\n".getBytes());

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        System.setIn(in);
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
        System.setIn(null);
    }

    @Test
    public void testMain() {
        try {
            Class<?> c = Class.forName("lsg.LearningSoulsGame");
            Method m = c.getMethod("main", String[].class);
            Object[] args = new Object[1];

            args[0] = new String[]{};
            m.invoke(null, args);

            String[] list = outContent.toString().split("\n");

            Assert.assertEquals(list.length, 71);
            Assert.assertEquals("Gregooninator picks up Dragon Slayer Leggings(10.2)", list[0]);
            Assert.assertEquals("Gregooninator picks up Ringed Knight Armor(14.99)", list[1]);
            Assert.assertEquals("Gregooninator picks up ShotGun (min:6 max:20 stam:5 dur:100)", list[2]);
            Assert.assertEquals("", list[3]);
            Assert.assertEquals("BAG : SmallBag [ 3 items | 9/10 kg ]", list[4]);

            String[] list2 = Arrays.copyOfRange(list, 5, 8);

            Assert.assertTrue(Arrays.asList(list2).contains("∙ Ringed Knight Armor(14.99)[4 kg]"));
            Assert.assertTrue(Arrays.asList(list2).contains("∙ Dragon Slayer Leggings(10.2)[3 kg]"));
            Assert.assertTrue(Arrays.asList(list2).contains("∙ ShotGun (min:6 max:20 stam:5 dur:100)[2 kg]"));

            Assert.assertEquals("", list[8]);
            Assert.assertEquals("Gregooninator changes SmallBag for MediumBag", list[9]);
            Assert.assertEquals("", list[10]);
            Assert.assertEquals("BAG : MediumBag [ 3 items | 9/40 kg ]", list[11]);

            String[] list3 = Arrays.copyOfRange(list, 12, 15);

            Assert.assertTrue(Arrays.asList(list3).contains("∙ Ringed Knight Armor(14.99)[4 kg]"));
            Assert.assertTrue(Arrays.asList(list3).contains("∙ Dragon Slayer Leggings(10.2)[3 kg]"));
            Assert.assertTrue(Arrays.asList(list3).contains("∙ ShotGun (min:6 max:20 stam:5 dur:100)[2 kg]"));

            Assert.assertEquals("", list[15]);
            Assert.assertEquals("Gregooninator picks up Hot Grandmother Coffee [10 stamina point(s)]", list[16]);
            Assert.assertEquals("Gregooninator picks up Uncle Greg's spicy Maroilles burger [40 life point(s)]", list[17]);
            Assert.assertEquals("Gregooninator picks up 12 years old Oban [150 stamina point(s)]", list[18]);
            Assert.assertEquals("Gregooninator picks up Repair Kit [10 durability point(s)]", list[19]);
            Assert.assertEquals("Gregooninator picks up Repair Kit [10 durability point(s)]", list[20]);
            Assert.assertEquals("", list[21]);
            Assert.assertEquals("BAG : MediumBag [ 8 items | 14/40 kg ]", list[22]);

            String[] list4 = Arrays.copyOfRange(list, 23, 31);

            Assert.assertTrue(Arrays.asList(list4).contains("∙ Ringed Knight Armor(14.99)[4 kg]"));
            Assert.assertTrue(Arrays.asList(list4).contains("∙ Dragon Slayer Leggings(10.2)[3 kg]"));
            Assert.assertTrue(Arrays.asList(list4).contains("∙ ShotGun (min:6 max:20 stam:5 dur:100)[2 kg]"));
            Assert.assertTrue(Arrays.asList(list4).contains("∙ Repair Kit [10 durability point(s)][1 kg]"));
            Assert.assertTrue(Arrays.asList(list4).contains("∙ Uncle Greg's spicy Maroilles burger [40 life point(s)][1 kg]"));
            Assert.assertTrue(Arrays.asList(list4).contains("∙ 12 years old Oban [150 stamina point(s)][1 kg]"));
            Assert.assertTrue(Arrays.asList(list4).contains("∙ Hot Grandmother Coffee [10 stamina point(s)][1 kg]"));

            Assert.assertEquals("", list[31]);
            Assert.assertEquals("--- AVANT ---", list[32]);
            Assert.assertEquals("[ Hero ]             Gregooninator        LIFE:  100      STAMINA:   50      PROTECTION:  0.00     BUFF:  0.00    (ALIVE)", list[33]);
            Assert.assertEquals("ARMOR   1:empty                           2:empty                           3:empty                         TOTAL:0.0", list[34]);
            Assert.assertEquals("WEAPON : null", list[35]);
            Assert.assertEquals("BAG : MediumBag [ 8 items | 14/40 kg ]", list[36]);

            String[] list5 = Arrays.copyOfRange(list, 37, 45);

            Assert.assertTrue(Arrays.asList(list5).contains("∙ Ringed Knight Armor(14.99)[4 kg]"));
            Assert.assertTrue(Arrays.asList(list5).contains("∙ Dragon Slayer Leggings(10.2)[3 kg]"));
            Assert.assertTrue(Arrays.asList(list5).contains("∙ ShotGun (min:6 max:20 stam:5 dur:100)[2 kg]"));
            Assert.assertTrue(Arrays.asList(list5).contains("∙ Repair Kit [10 durability point(s)][1 kg]"));
            Assert.assertTrue(Arrays.asList(list5).contains("∙ Uncle Greg's spicy Maroilles burger [40 life point(s)][1 kg]"));
            Assert.assertTrue(Arrays.asList(list5).contains("∙ 12 years old Oban [150 stamina point(s)][1 kg]"));
            Assert.assertTrue(Arrays.asList(list5).contains("∙ Hot Grandmother Coffee [10 stamina point(s)][1 kg]"));

            Assert.assertEquals("", list[45]);
            Assert.assertEquals("--- ACTIONS ---", list[46]);
            Assert.assertEquals("Gregooninator pulls out Hot Grandmother Coffee [10 stamina point(s)]", list[47]);
            Assert.assertEquals("", list[48]);
            Assert.assertEquals("Gregooninator drinks Hot Grandmother Coffee [10 stamina point(s)]", list[49]);
            Assert.assertEquals("", list[50]);
            Assert.assertEquals("Gregooninator pulls out Uncle Greg's spicy Maroilles burger [40 life point(s)]", list[51]);
            Assert.assertEquals("", list[52]);
            Assert.assertEquals("Gregooninator eats Uncle Greg's spicy Maroilles burger [40 life point(s)]", list[53]);
            Assert.assertEquals("", list[54]);
            Assert.assertEquals("Gregooninator pulls out ShotGun (min:6 max:20 stam:5 dur:100) and equips it !", list[55]);
            Assert.assertEquals("", list[56]);
            Assert.assertEquals("Gregooninator pulls out Dragon Slayer Leggings(10.2) and equips it !", list[57]);
            Assert.assertEquals("", list[58]);
            Assert.assertEquals("Gregooninator pulls out Repair Kit [10 durability point(s)]", list[59]);
            Assert.assertEquals("", list[60]);
            Assert.assertEquals("Gregooninator repairs ShotGun (min:6 max:20 stam:5 dur:100) with Repair Kit [10 durability point(s)]", list[61]);
            Assert.assertEquals("", list[62]);
            Assert.assertEquals("--- APRES ---", list[63]);
            Assert.assertEquals("[ Hero ]             Gregooninator        LIFE:  100      STAMINA:   50      PROTECTION: 10.20     BUFF:  0.00    (ALIVE)", list[64]);
            Assert.assertEquals("ARMOR   1:Dragon Slayer Leggings(10.2)    2:empty                           3:empty                         TOTAL:10.2", list[65]);
            Assert.assertEquals("WEAPON : ShotGun (min:6 max:20 stam:5 dur:101)", list[66]);
            Assert.assertEquals("BAG : MediumBag [ 3 items | 6/40 kg ]", list[67]);

            String[] list6 = Arrays.copyOfRange(list, 68, 72);

            Assert.assertTrue(Arrays.asList(list6).contains("∙ Ringed Knight Armor(14.99)[4 kg]"));
            Assert.assertTrue(Arrays.asList(list6).contains("∙ Repair Kit [10 durability point(s)][1 kg]"));
            Assert.assertTrue(Arrays.asList(list6).contains("∙ 12 years old Oban [150 stamina point(s)][1 kg]"));
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called LearningSoulsGame");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have static method called main");
        } catch (IllegalAccessException e) {
            Assert.fail("IllegalAccessException");
        } catch (InvocationTargetException e) {
            Assert.fail("InvocationTargetException");
        }
    }

    @Test
    public void testMainV2() {
        try {
            Class<?> c = Class.forName("lsg.LearningSoulsGame");
            Method m = c.getMethod("main", String[].class);
            Object[] args = new Object[1];

            args[0] = new String[]{};
            m.invoke(null, args);

            String[] list = outContent.toString().split("\n");

            Assert.assertEquals(list.length, 71);
            Assert.assertEquals("Gregooninator picks up Dragon Slayer Leggings(10.2)", list[0]);
            Assert.assertEquals("Gregooninator picks up Ringed Knight Armor(14.99)", list[1]);
            Assert.assertEquals("Gregooninator picks up ShotGun (min:6 max:20 stam:5 dur:100)", list[2]);
            Assert.assertEquals("", list[3]);
            Assert.assertEquals("BAG : SmallBag [ 3 items | 9/10 kg ]", list[4]);

            String[] list2 = Arrays.copyOfRange(list, 5, 8);

            Assert.assertTrue(Arrays.asList(list2).contains("∙ Ringed Knight Armor(14.99)[4 kg]"));
            Assert.assertTrue(Arrays.asList(list2).contains("∙ Dragon Slayer Leggings(10.2)[3 kg]"));
            Assert.assertTrue(Arrays.asList(list2).contains("∙ ShotGun (min:6 max:20 stam:5 dur:100)[2 kg]"));

            Assert.assertEquals("", list[8]);
            Assert.assertEquals("Gregooninator changes SmallBag for MediumBag", list[9]);
            Assert.assertEquals("", list[10]);
            Assert.assertEquals("BAG : MediumBag [ 3 items | 9/40 kg ]", list[11]);

            String[] list3 = Arrays.copyOfRange(list, 12, 15);

            Assert.assertTrue(Arrays.asList(list3).contains("∙ Ringed Knight Armor(14.99)[4 kg]"));
            Assert.assertTrue(Arrays.asList(list3).contains("∙ Dragon Slayer Leggings(10.2)[3 kg]"));
            Assert.assertTrue(Arrays.asList(list3).contains("∙ ShotGun (min:6 max:20 stam:5 dur:100)[2 kg]"));

            Assert.assertEquals("", list[15]);
            Assert.assertEquals("Gregooninator picks up Hot Grandmother Coffee [10 stamina point(s)]", list[16]);
            Assert.assertEquals("Gregooninator picks up Uncle Greg's spicy Maroilles burger [40 life point(s)]", list[17]);
            Assert.assertEquals("Gregooninator picks up 12 years old Oban [150 stamina point(s)]", list[18]);
            Assert.assertEquals("Gregooninator picks up Repair Kit [10 durability point(s)]", list[19]);
            Assert.assertEquals("Gregooninator picks up Repair Kit [10 durability point(s)]", list[20]);
            Assert.assertEquals("", list[21]);
            Assert.assertEquals("BAG : MediumBag [ 8 items | 14/40 kg ]", list[22]);

            String[] list4 = Arrays.copyOfRange(list, 23, 31);

            Assert.assertTrue(Arrays.asList(list4).contains("∙ Ringed Knight Armor(14.99)[4 kg]"));
            Assert.assertTrue(Arrays.asList(list4).contains("∙ Dragon Slayer Leggings(10.2)[3 kg]"));
            Assert.assertTrue(Arrays.asList(list4).contains("∙ ShotGun (min:6 max:20 stam:5 dur:100)[2 kg]"));
            Assert.assertTrue(Arrays.asList(list4).contains("∙ Repair Kit [10 durability point(s)][1 kg]"));
            Assert.assertTrue(Arrays.asList(list4).contains("∙ Uncle Greg's spicy Maroilles burger [40 life point(s)][1 kg]"));
            Assert.assertTrue(Arrays.asList(list4).contains("∙ 12 years old Oban [150 stamina point(s)][1 kg]"));
            Assert.assertTrue(Arrays.asList(list4).contains("∙ Hot Grandmother Coffee [10 stamina point(s)][1 kg]"));

            Assert.assertEquals("", list[31]);
            Assert.assertEquals("--- AVANT ---", list[32]);
            Assert.assertEquals("[ Hero ]             Gregooninator        LIFE:  100      STAMINA:   50      PROTECTION:  0.00     BUFF:  0.00    (ALIVE)", list[33]);
            Assert.assertEquals("ARMOR   1:empty                           2:empty                           3:empty                         TOTAL:0.0", list[34]);
            Assert.assertEquals("WEAPON : null", list[35]);
            Assert.assertEquals("BAG : MediumBag [ 8 items | 14/40 kg ]", list[36]);

            String[] list5 = Arrays.copyOfRange(list, 37, 45);

            Assert.assertTrue(Arrays.asList(list5).contains("∙ Ringed Knight Armor(14.99)[4 kg]"));
            Assert.assertTrue(Arrays.asList(list5).contains("∙ Dragon Slayer Leggings(10.2)[3 kg]"));
            Assert.assertTrue(Arrays.asList(list5).contains("∙ ShotGun (min:6 max:20 stam:5 dur:100)[2 kg]"));
            Assert.assertTrue(Arrays.asList(list5).contains("∙ Repair Kit [10 durability point(s)][1 kg]"));
            Assert.assertTrue(Arrays.asList(list5).contains("∙ Uncle Greg's spicy Maroilles burger [40 life point(s)][1 kg]"));
            Assert.assertTrue(Arrays.asList(list5).contains("∙ 12 years old Oban [150 stamina point(s)][1 kg]"));
            Assert.assertTrue(Arrays.asList(list5).contains("∙ Hot Grandmother Coffee [10 stamina point(s)][1 kg]"));

            Assert.assertEquals("", list[45]);
            Assert.assertEquals("--- ACTIONS ---", list[46]);
            Assert.assertEquals("Gregooninator drinks FAST :", list[47]);
            Assert.assertEquals("Gregooninator drinks Hot Grandmother Coffee [10 stamina point(s)]", list[48]);
            Assert.assertEquals("Gregooninator pulls out Hot Grandmother Coffee [0 stamina point(s)]", list[49]);
            Assert.assertEquals("", list[50]);
            Assert.assertEquals("Gregooninator eats FAST :", list[51]);
            Assert.assertEquals("Gregooninator eats Uncle Greg's spicy Maroilles burger [40 life point(s)]", list[52]);
            Assert.assertEquals("Gregooninator pulls out Uncle Greg's spicy Maroilles burger [0 life point(s)]", list[53]);
            Assert.assertEquals("", list[54]);
            Assert.assertEquals("Gregooninator pulls out ShotGun (min:6 max:20 stam:5 dur:100) and equips it !", list[55]);
            Assert.assertEquals("", list[56]);
            Assert.assertEquals("Gregooninator pulls out Dragon Slayer Leggings(10.2) and equips it !", list[57]);
            Assert.assertEquals("", list[58]);
            Assert.assertEquals("Gregooninator repairs FAST :", list[59]);
            Assert.assertEquals("Gregooninator repairs ShotGun (min:6 max:20 stam:5 dur:100) with Repair Kit [10 durability point(s)]", list[60]);
            Assert.assertEquals("", list[61]);
            Assert.assertEquals("--- APRES ---", list[62]);
            Assert.assertEquals("[ Hero ]             Gregooninator        LIFE:  100      STAMINA:   50      PROTECTION: 10.20     BUFF:  0.00    (ALIVE)", list[63]);
            Assert.assertEquals("ARMOR   1:Dragon Slayer Leggings(10.2)    2:empty                           3:empty                         TOTAL:10.2", list[64]);
            Assert.assertEquals("WEAPON : ShotGun (min:6 max:20 stam:5 dur:101)", list[65]);
            Assert.assertEquals("BAG : MediumBag [ 4 items | 7/40 kg ]", list[66]);

            String[] list6 = Arrays.copyOfRange(list, 67, 71);

            Assert.assertTrue(Arrays.asList(list6).contains("∙ Ringed Knight Armor(14.99)[4 kg]"));
            Assert.assertTrue(Arrays.asList(list6).contains("∙ Repair Kit [10 durability point(s)][1 kg]"));
            Assert.assertTrue(Arrays.asList(list6).contains("∙ 12 years old Oban [150 stamina point(s)][1 kg]"));
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called LearningSoulsGame");
        } catch (NoSuchMethodException e) {
            Assert.fail("should have static method called main");
        } catch (IllegalAccessException e) {
            Assert.fail("IllegalAccessException");
        } catch (InvocationTargetException e) {
            Assert.fail("InvocationTargetException");
        }
    }
}