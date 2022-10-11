import java.util.List;

public class BookMarkNode
{
    String title;
    URL bkNode_url;
    String parent;
    List<BookMarkNode> children;
}

class URL
{
    String url_name;
    String url;
    String parent_node;
}
