package com.umit;

    public class Switch_Case {

        public static void main(String[] args) {
            /**
             * Switch case if else ile benzerdir.Java 7 ye kadar sadece integer degerler icin kullanilabiliyordu
             * Java 8 de String ve Enum type lar icin de kullanilabilir oldu.
             *
             */

            //Java 8 den once

            int deger=2;
            switch (deger){
                case 1:
                    System.out.println("bir");break;
                case 2:
                    System.out.println("iki");break;
                default: System.out.println(" ");
            }

            //Java 8 den sonra -String-

            String gun="Cuma";
            switch (gun){
                case "Salı": System.out.println("Hafta ici");break;
                case "Cuma": System.out.println("Hafta ici");break;
                case "Pazar": System.out.println("Hafta sonu");break;
                default: System.out.println(" ");
            }
            //enum
            enum GUNLER{
                Pazartesi,Sali,Cuma,Pazar
            }
            GUNLER gunler= GUNLER.Pazar;
            switch (gunler){
                case Sali: System.out.println( "Hafta ici");break;
                case Cuma: System.out.println("Hafta ici");break;
                case Pazar: System.out.println("Hafta sonu");break;
                default: System.out.println(" ");
            }

            /**
             * Switch statemen’i artik bir switch expression’a donustu. Yani assign
             * edilebilen, return edilebilen bir yapiya kavustu. Fakat return edilecek
             * ifadeden önce yield kullanilmasi gerekir.
             */

            String type= switch (gun) {
                case "Sali": yield "Hafta ici";
                case "Cuma": yield "Hafta ici";
                case "Pazar": yield "Hafta sonu";
                default: yield " ";
            };

            /**
             * case statement’ı arrow operator olarak tanımlanabilir hale geldi.
             * Yield yerine bu kullanım daha okunur olduğu için bu ifadenin tercih
             * edilmesi daha faydalı olabilir
             */

            String day="Sunday";
            String type1 = switch (day) {
                case "Monday"-> "Week day";
                case "Tuesday"-> "Week day";
                case "Wednesday"->"Week day";
                case "Thursday"->"Week day";
                case "Friday"->"Week day";
                case "Saturday"-> "Weekend";
                case "Sunday"-> "Weekend";
                default->"Unknown";
            };

            /**
             * switch içinde yer alan değerin farklı case’leri için aynı işlem
             * yapılabilmesini sağlamak için tek bir case ifadesine farklı labellar
             * yazılabilir hale geldi:
             */

            String type2 = switch (day) {
                case "Monday","Tuesday","Wednesday","Thursday","Friday" -> "Week day";
                case "Saturday", "Sunday" -> "Weekend";
                default->"Unknown";
            };

            /**
             * Pattern matching: Diyelim ki elimizde bir deger var ve bu degerin tipine
             * gore casting islemi yaparak donusturdugumuz tipin icerdigi metotlari kullanarak
             * belli islemler yapmamiz gerekiyor. Bunun icin Java’nin pattern matching özelligini
             * kullanabiliriz. instanceOf keyword’u ile bir objenin hangi sinifa ait oldugunu boolean
             * bir deger döndürerek kontrol edebiliriz. Ve bu sayede elimizdeki daha abstract (soyut)
             * olan bir objeyi casting yontemi ile belli subclass’lara cevirebiliriz:
             */
            Object o = 5;
            double result;
            if (o instanceof Integer) {
                result = ((Integer) o).doubleValue();
            } else if (o instanceof Float) {
                result = ((Float) o).doubleValue();
            } else if (o instanceof String) {
                result = Double.parseDouble(((String) o));
            } else {
                result = 0d;
            }
            System.out.println(result);

            /**
             * Guarded Pattern: Pattern matching işlemini yaparken ayrıca farklı koşullar eklememiz
             * gerektiğinde aşağıdaki gibi case ifadesinin altında if-else ler eklememiz gerekiyor:
             */

            /**Object ob = "10";

             Object result1 = switch (o) {
             case Integer i -> i.doubleValue();
             case Float f -> f.doubleValue();
             case String s -> {
             if (s.length() > 0) {
             yield Double.parseDouble(s);
             } else {
             yield 0d;
             }
             }
             default -> 0d;
             };
             */




            /**
             * Artık Guarded Patterns ile birlikte casting’den hemen sonra cast edilen sınıfın
             * özelliklerini kullanan boolean expressionlar yazılabilir ve bu expressionları
             * boolean operandlar ile casting işlemine bağlanabilir:
             */
            /** o = "10";

             Object result = switch (o) {
             case Integer i -> i.doubleValue();
             case Float f -> f.doubleValue();
             case String s && (s.length() > 0 || s.length() < 5) -> {
             yield Double.parseDouble(s);
             }
             default -> 0d;
             };
             System.out.println(result); //10.0
             */



            /**
             * Null Cases: Java 17 öncesinde, switch-case’e geçmiş olduğunuz bir değerin asla null
             * olmaması gerekiyordu. Artık Java 17 ile birlikte bu kısıt kaldırıldı ve null olması
             * durumu case labelları ile ele alınabilir hale geldi:
             */
            /**Object obj = null;

             Object result5 = switch (o) {
             case Integer i -> i.doubleValue();
             case Float f -> f.doubleValue();
             case null -> 0d;
             default -> 0d;
             };
             */

        }//main sonu

    }//class sonu



