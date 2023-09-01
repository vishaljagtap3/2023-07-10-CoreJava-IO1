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

        Util.bufferedInputStreamDemo2(basePath + "bigfile.txt");

    }
}
