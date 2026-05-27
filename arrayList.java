import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class arrayList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        // Thêm phần tử vào mảng
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        System.out.println("Danh sach ban dau:" + list);
        // Sửa phần tử trong mảng dựa vào index
        // Cú pháp list.set(index,value)
        list.set(1, 99);
        System.out.println("Sau khi sua:" + list);
        // Xóa phần tử tại vị trí index
        list.remove(2);
        System.out.println("Sau khi xoa:" + list);
        // Tìm kiếm
        System.out.println("Nhap so can tim:");
        int k = sc.nextInt();
        if (list.contains(k)) {
            System.out.println("Co tim thay " + k + " tai vi tri index: " + list.indexOf(k));
        } else {
            System.out.println("Khong tim thay !");
        }
        // Sắp xếp
        Collections.sort(list); // Tăng dần
        System.out.println("Sau khi tang dan:" + list);
        // Giảm dần
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("Sau khi giam dan:" + list);
        sc.close();
    }
}
