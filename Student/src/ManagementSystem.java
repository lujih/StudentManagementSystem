import java.util.ArrayList;
import java.util.Scanner;

public class ManagementSystem {
    public static void main(String[] args) {
        //### 需求：
        //
        //采取控制台的方式去书写学生管理系统。
        //
        //#### 初始菜单：
        //
        //"-------------欢迎来到黑马学生管理系统----------------"
        //"1：添加学生"
        //"2：删除学生"
        //"3：修改学生"
        //"4：查询学生"
        //"5：退出"
        //"请输入您的选择:"
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> als = new ArrayList<>();
        int c = 0;
        while (true) {
            System.out.println("-------------欢迎来到黑马学生管理系统----------------");
            System.out.println("1：添加学生");
            System.out.println("2：删除学生");
            System.out.println("3：修改学生");
            System.out.println("4：查询学生");
            System.out.println("5：退出");
            System.out.println("请输入您的选择:");
            int options = sc.nextInt();
            switch (options) {
                //添加学生
                case 1:
                    als.add(addTo(c, als));
                    c++;
                    continue;
                    //删除学生
                case 2:
                    del(als);
                    continue;
                    //修改学生
                case 3:
                    modify(als);
                    continue;
                    //查询学生
                case 4:
                    showinf(als);
                    continue;
                    //退出
                case 5:
                    System.out.println("你已退出黑马学生管理系统");
                    return;
            }
        }
    }


    //添加功能：
    //
    //键盘录入每一个学生信息并添加，需要满足以下要求：
    //
    //id唯一
    public static Student addTo(int frequency, ArrayList<Student> als) {
        Student s = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.println("输入学生id:");
        String id = sc.next();
        if (frequency > 0) {
            for (int i = 0; i < als.size(); i++) {
                if (id.equals(als.get(i).getId())) {
                    System.out.println("id重复,请返回菜单重新操作.");
                    return null;
                }
            }
        }
        s.setId(id);
        System.out.println("输入学生姓名:");
        s.setName(sc.next());
        System.out.println("输入学生年龄:");
        s.setAge(sc.nextInt());
        System.out.println("输入学生家庭住址:");
        s.setHome(sc.next());
        return s;
    }

    //删除功能：
    //
    //键盘录入要删除的学生id，需要满足以下要求：
    //
    //id存在删除
    //id不存在，需要提示不存在，并回到初始菜单

    public static void del(ArrayList<Student> als) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的学生id:");
        String delid = sc.next();
        int t = -1;
        for (int i = 0; i < als.size(); i++) {
            if (!delid.equals(als.get(i).getId())) {

            } else {
                t = i;
            }
        }
        if (t == -1) {
            System.out.println("当前id不存在，反回到初始菜单.");
        } else {
            System.out.println("id为:" + delid + "的学生信息已删除.");
            als.remove(t);
        }
    }

    //修改功能：
    //
    //键盘录入要修改的学生id，需要满足以下要求
    //
    //id存在，继续录入其他信息
    //id不存在，需要提示不存在，并回到初始菜单

    public static void modify(ArrayList<Student> als) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的学生id:");
        String modid = sc.next();
        int t = -1;
        for (int i = 0; i < als.size(); i++) {
            if (!modid.equals(als.get(i).getId())) {

            } else {
                t = i;
            }
        }
        if (t == -1) {
            System.out.println("当前id不存在，反回到初始菜单.");
        } else {
            while (true) {
                System.out.println("-------------修改学生信息菜单----------------");
                System.out.println("1：修改学生id");
                System.out.println("2：修改学生姓名");
                System.out.println("3：修改学生年龄");
                System.out.println("4：修改学生家庭住址");
                System.out.println("5：返回主菜单");
                System.out.println("请输入您的选择:");
                int options = sc.nextInt();
                switch (options) {
                    //添加学生
                    case 1:
                        System.out.println("还没写");
                        continue;
                        //删除学生
                    case 2:
                        System.out.println("还没写");
                        continue;
                        //修改学生
                    case 3:
                        System.out.println("还没写");
                        continue;
                        //查询学生
                    case 4:
                        System.out.println("还没写");
                        continue;
                        //退出
                    case 5:
                        System.out.println("你将返回主菜单");
                        return;
                }
            }
        }
    }


    //查询功能：
    //
    //打印所有的学生信息，需要满足以下要求
    //
    //如果没有学生信息，提示：当前无学生信息，请添加后再查询
    //如果有学生信息，需要按照以下格式输出。（不用过于纠结对齐的问题）
    //
    //id		姓名		年龄	家庭住址
    //heima001	张三		23		 南京
    //heima002	李四		24		 北京
    //heima003	王五		25		 广州
    //heima004	赵六	 	26		 深圳

    public static void showinf(ArrayList<Student> als) {
        if (als.get(0).getId() == null) {
            System.out.println("当前无学生信息，请添加后再查询.");
        } else {
            System.out.println("id" + "\t姓名" + "\t年龄" + "\t家庭住址");
            for (int i = 0; i < als.size(); i++) {
                if (als.get(i) != null) {
                    Student stu = als.get(i);
                    System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t" + stu.getHome());
                }
            }
        }
    }
}
