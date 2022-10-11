import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        BookMarkTree bk_tree = new BookMarkTree();
        String[] codes = new String[5];
        String[] tags = new String[2];


        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入指令");
        while(scanner.hasNextLine() == true)
        {
            String str = scanner.nextLine();

            codes = null;
            codes = str.split("\"");  //所有切割后的字符串
            for(int i = 0;i < codes.length;i++)
            {
                codes[i] = codes[i].trim();
                //System.out.println(codes[i]);
            }
            tags = null;
            tags = codes[0].split("-"); //对切割后的第一个字符串进行切割
            //System.out.println(tags[0]);
            bk_tree.AddItem(bk_tree.headNode.title, "课程");
            bk_tree.AddItem("课程", "参考资料");
            switch (tags[0])
            {
                case "add":
                    if(tags[1].equals("title"))
                    {
                        if(codes.length > 2)
                        {
                            bk_tree.AddItem(codes[3], codes[1]);
                        }
                        else
                        {
                            bk_tree.AddItem(bk_tree.headNode.title, codes[1]);
                        }
                    }
                    else
                    {
                        bk_tree.AddItem(codes[1], codes[3], codes[5]);
                    }
            }
            //System.out.println(bk_tree.headNode.children.get(0).title);
            //System.out.println(bk_tree.headNode.children.get(0).children.get(0).title);
            System.out.println(bk_tree.headNode.children.get(0).children.get(0).bkNode_url.url_name);
            System.out.println(bk_tree.headNode.children.get(0).children.get(0).bkNode_url.url);
            System.out.println(bk_tree.headNode.children.get(0).children.get(0).bkNode_url.parent_node);
        }
        scanner.close();
    }
}