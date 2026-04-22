
public class BaiHat
{
    public static void main(String[] args) {
     String path="D:/music/bolero/longme.mp3";

    int lastSlash=path.lastIndexOf("/"); // tìm dấu gạch cuối cùng của chuỗi
    String filename=path.substring(lastSlash+1);
    System.out.println("Ket qua 1: "+filename);

    // lay longme
    int lastDOT =filename.lastIndexOf("."); // tìm dấu chấm cuối cùng
    String nameOnly=filename.substring(0, lastDOT);
    System.out.println("Ket qua 2: "+nameOnly);
    }
}