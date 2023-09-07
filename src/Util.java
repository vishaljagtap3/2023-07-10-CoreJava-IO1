import java.io.*;
import java.util.Scanner;

public class Util {

    public static void fileInputStreamDemo1(String filePath) {

        try {
            FileInputStream fin = new FileInputStream(filePath);
            int val = 0;

            long startTime = System.currentTimeMillis();

            while (val != -1) {
                val = fin.read();
                if (val != -1) {
                    //System.out.print((char)val);
                }
            }

            System.out.println("\ntime : " + (System.currentTimeMillis() - startTime));

            fin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void fileInputStreamDemo2(String filePath) {

        try {
            FileInputStream fin = new FileInputStream(filePath);
            int val = 0;

            System.out.println("Available : " + fin.available());

            long startTime = System.currentTimeMillis();

            byte[] arr = new byte[1024 * 8];
            int count = 0;
            while (count != -1) {
                //count = fin.read(arr);
                count = fin.read(arr, 0, arr.length);
                /*if(count != -1) {
                    System.out.print(new String(arr, 0, count));
                }*/
            }

            System.out.println("\ntime : " + (System.currentTimeMillis() - startTime));
            System.out.println("Available : " + fin.available());

            fin.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void byteArrayInputStreamDemo() {
        byte[] bytes = "This is a String..!".getBytes();

        //ByteArrayInputStream bin = new ByteArrayInputStream(bytes);
        ByteArrayInputStream bin = new ByteArrayInputStream(bytes, 2, 5);

        int val;
        while ((val = bin.read()) != -1) {
            System.out.print((char) val);
        }

        try {
            bin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void pushbackInputStreamDemo() {
        ByteArrayInputStream bin = new ByteArrayInputStream(
                "BitCode is Best!".getBytes()
        );
        PushbackInputStream pin = new PushbackInputStream(bin);

        try {
            int val = pin.read();
            System.out.println((char) val);
            pin.unread(val);
            val = pin.read();
            System.out.println((char) val);

            pin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void sequenceInputStreamDemo() throws FileNotFoundException {
        FileInputStream fin = new FileInputStream("/home/vishal/java/new-demos/bitcode.txt");
        ByteArrayInputStream bin = new ByteArrayInputStream(
                "BitCode is Best!".getBytes()
        );

        SequenceInputStream sin = new SequenceInputStream(fin, bin);
        int val;
        try {
            while ((val = sin.read()) != -1) {
                System.out.print((char) val);
            }
            sin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void sequenceInputStreamDemo1() throws FileNotFoundException {
        FileInputStream fin = new FileInputStream("/home/vishal/java/new-demos/bitcode.txt");
        ByteArrayInputStream bin = new ByteArrayInputStream(
                "BitCode is Best!".getBytes()
        );

        SequenceInputStream sin = new SequenceInputStream(fin, bin);
        PushbackInputStream pin = new PushbackInputStream(sin);

        int val;
        try {
            while ((val = pin.read()) != -1) {
                System.out.print((char) val);
            }
            pin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void bufferedInputStreamDemo2(String filePath) {

        try {
            FileInputStream fin = new FileInputStream(filePath);
            BufferedInputStream bin = new BufferedInputStream(fin, 16 * 1024);
            int val = 0;

            System.out.println("Available : " + bin.available());

            long startTime = System.currentTimeMillis();

            byte[] arr = new byte[1024 * 8];
            int count = 0;
            while (count != -1) {
                //count = fin.read(arr);
                count = bin.read(arr, 0, arr.length);
                /*if(count != -1) {
                    System.out.print(new String(arr, 0, count));
                }*/
            }

            System.out.println("\ntime : " + (System.currentTimeMillis() - startTime));
            System.out.println("Available : " + bin.available());

            bin.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void fileOutputStreamDemo1(String filePath) {

        try {

            FileOutputStream fout = new FileOutputStream(filePath, true);
            fout.write("java is good".getBytes());
            fout.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static boolean fileCopy1(String src, String dest) {
        File fileIn = new File(src);
        if (!fileIn.exists()) {
            return false;
        }

        try {
            FileInputStream fin = new FileInputStream(src);
            FileOutputStream fout = new FileOutputStream(dest);

            byte[] data = new byte[1204 * 8];
            int count;
            while ((count = fin.read(data)) != -1) {
                fout.write(data, 0, count);
            }

            fin.close();
            fout.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static void byteArrayOutputStreamDemo() {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        try {
            bout.write("this is nice class".getBytes());
            byte[] data = bout.toByteArray();
            System.out.println(new String(data));
            bout.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printStreamDemo(String filePath) {
        try {
            int i = 0;
            PrintStream ps = new PrintStream(new FileOutputStream(filePath));
            ps.println("I am living in a " + i + "\n");
            ps.print('A');
            ps.print('B');
            ps.print("\n");
            ps.println(909123);
            ps.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //BufferedOutputStream
    public static boolean fileCopy2(String src, String dest) {
        File fileIn = new File(src);
        if (!fileIn.exists()) {
            return false;
        }

        try {
            BufferedInputStream buffIn =
                    new BufferedInputStream(
                            new FileInputStream(src)
                    );

            BufferedOutputStream buffOut = new BufferedOutputStream(
                    new FileOutputStream(dest)
            );

            byte[] data = new byte[1204 * 8];
            int count;
            while ((count = buffIn.read(data)) != -1) {
                buffOut.write(data, 0, count);
            }

            buffIn.close();
            buffOut.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static void dataInputOutputStreamDemo() {

        try {
            DataOutputStream dout =
                    new DataOutputStream(
                            new FileOutputStream("/home/vishal/java/new-demos/db_data.txt")
                    );
            dout.writeInt(1234);
            dout.writeFloat(12.12f);
            dout.writeBoolean(true);
            dout.writeUTF("bitcode");

            dout.close();

            DataInputStream din = new DataInputStream(
                    new FileInputStream("/home/vishal/java/new-demos/db_data.txt")
            );

            System.out.println(din.readInt());
            System.out.println(din.readFloat());
            System.out.println(din.readBoolean());
            System.out.println(din.readUTF());

            din.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void scannerDemo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextInt());
        System.out.println(scanner.nextFloat());
        scanner.nextLine();
        System.out.println(scanner.nextLine());
    }

    public static void readWriteObject(Student s) {
        try {
            DataOutputStream dout =
                    new DataOutputStream(
                            new FileOutputStream("/home/vishal/java/new-demos/student.data")
                    );
            dout.writeInt(s.getRoll());
            dout.writeUTF(s.getName());
            dout.writeFloat(s.getMarks());
            dout.writeUTF(s.getHobbies());
            dout.close();

            DataInputStream din =
                    new DataInputStream(
                            new FileInputStream("/home/vishal/java/new-demos/student.data")
                    );

            Student snew = new Student(din.readInt(), din.readUTF(), din.readFloat(), din.readUTF());
            System.out.println(snew);

            din.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void objectInputOutputStreamDemo(Student s) {
        String path = "/home/vishal/java/new-demos/student_objects.data";
        try {
            /*ObjectOutputStream out = new ObjectOutputStream(
                      new FileOutputStream(path)
            );
            out.writeObject(s);
            out.close();*/

           ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(path)
            );
            Student snew = (Student) in.readObject();
            in.close();

            System.out.println(snew);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void objectExternalizationDemo(Product p) {
        try {
            ObjectOutputStream out =
                    new ObjectOutputStream(
                            new FileOutputStream("/home/vishal/java/new-demos/products.db")
                    );
            out.writeObject(p);
            out.close();

            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream("/home/vishal/java/new-demos/products.db")
            );

            Product product = (Product) in.readObject();
            System.out.println(product);

            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
