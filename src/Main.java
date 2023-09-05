import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String basePath = "/home/vishal/java/new-demos/";

        //Util.fileInputStreamDemo1(basePath + "bitcode.txt");
        //Util.fileInputStreamDemo2(basePath + "bigfile.txt");
        //Util.fileInputStreamDemo2(basePath + "sample_video_1.mp4");

        //Util.byteArrayInputStreamDemo();

        //Util.pushbackInputStreamDemo();
        //Util.sequenceInputStreamDemo();
        //Util.sequenceInputStreamDemo1();

        //Util.bufferedInputStreamDemo2(basePath + "bigfile.txt");

        //Util.fileOutputStreamDemo1(basePath + "out1.txt");

        //Util.fileCopy1(basePath + "sample_video_1.mp4", basePath + "myvideo.mp4");
        //Util.fileCopy1(basePath + "bitcode.txt", basePath + "bitcode_data");

        //Util.byteArrayOutputStreamDemo();
        //Util.printStreamDemo(basePath + "ps_data.txt");
        //Util.fileCopy1(basePath + "sample_video_1.mp4", basePath + "myvideo_new.mp4");
        //Util.dataInputOutputStreamDemo();

        //Util.scannerDemo();

        Student s1 =
                new Student(11, "Everyone from java batch", 89, "sleeping, being lazy");
        //Util.readWriteObject(s1);
        Util.objectInputOutputStreamDemo(s1);

    }
}
