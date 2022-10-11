import javax.lang.model.type.NullType;
import java.beans.BeanInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BookMarkTree implements IAddIterm{
    String current_index_name;
    Stack<BookMarkNode> cache = new Stack<>();
    BookMarkNode headNode = new BookMarkNode();

    BookMarkTree()
    {
        headNode.title = "个人收藏";
        headNode.bkNode_url = null;
        headNode.children = new ArrayList<>();
        headNode.parent = null;
    }

    public BookMarkNode GetNodeBytitle(BookMarkNode node, String title) {
        BookMarkNode target_node = null;

        if(node.title.equals(title))
            target_node = node;
        else
        {
            for(int i = 0;i < node.children.size();i++)
            {
                if(node.children.get(i).title.equals(title))
                {
                    target_node = node.children.get(i);
                    break;
                }

                if(node.children.get(i) != null)
                {
                    target_node = GetNodeBytitle(node.children.get(i), title);
                }
            }
        }
        //System.out.println(target_node.title);
        return target_node;
    }

    @Override
    public void AddItem(String parent, String target)
    {
        BookMarkNode bkNode = new BookMarkNode();
        bkNode.title = target;
        bkNode.bkNode_url = null;
        bkNode.children = new ArrayList<>();
        bkNode.parent = parent;

        BookMarkNode node_parent = GetNodeBytitle(headNode, parent);
        node_parent.children.add(bkNode);
        //System.out.println(node_parent.title);
    }

    public void AddItem(String url_name, String url, String parent)
    {
        URL node_url = new URL();
        node_url.url_name = url_name;
        node_url.url = url;
        node_url.parent_node = parent;

        BookMarkNode node_parent = GetNodeBytitle(headNode, parent);
        node_parent.bkNode_url = node_url;
    }
}