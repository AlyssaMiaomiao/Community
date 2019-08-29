package com.nowcoder.community.entity;

/**
<<<<<<< HEAD
 * 封装分页相关的信息.
 */
public class Page {

    // 当前页码
    private int current = 1;
    // 显示上限
    private int limit = 10;
    // 数据总数(用于计算总页数)
    private int rows;
    // 查询路径(用于复用分页链接)
=======
 * 用于封装分页的信息
 */
public class Page {
    //当前页码
    private int current=1;
    //显示上限
    private int limit=10;
    //数据总数（用于计算总页数）
    private int rows;
    //查询路径（用于复用分页链接）
>>>>>>> 2965fdde98e956b8b636b00cee29f2367d6615b0
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
<<<<<<< HEAD
        if (current >= 1) {
=======
        if(current>=1) {
>>>>>>> 2965fdde98e956b8b636b00cee29f2367d6615b0
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
<<<<<<< HEAD
        if (limit >= 1 && limit <= 100) {
=======
        if(limit>=1&&limit<=100){
>>>>>>> 2965fdde98e956b8b636b00cee29f2367d6615b0
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
<<<<<<< HEAD
        if (rows >= 0) {
=======
        if(rows>=0){
>>>>>>> 2965fdde98e956b8b636b00cee29f2367d6615b0
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
<<<<<<< HEAD

    /**
     * 获取当前页的起始行
     *
     * @return
     */
    public int getOffset() {
        // current * limit - limit
        return (current - 1) * limit;
    }

    /**
     * 获取总页数
     *
     * @return
     */
    public int getTotal() {
        // rows / limit [+1]
        if (rows % limit == 0) {
            return rows / limit;
        } else {
            return rows / limit + 1;
        }
    }

    /**
     * 获取起始页码
     *
     * @return
     */
    public int getFrom() {
        int from = current - 2;
        return from < 1 ? 1 : from;
    }

    /**
     * 获取结束页码
     *
     * @return
     */
    public int getTo() {
        int to = current + 2;
        int total = getTotal();
        return to > total ? total : to;
    }

=======
    //数据库的查询语句传进去的是offset而不是页码，所以要将页码转成offset
    public int getOffset(){
        return (current-1)*limit;
    }
    //获取总的页数
    public int getTotal(){
        return rows%limit==0?rows/limit:rows/limit+1;
    }
    //下面的两个方法是用于显示页码的数量的，从第几页到第几页
    public int getFrom(){
        int from=current-2;
       return from<1?1:from;
    }
    public int getTo(){
        int to=current+2;
        int total=getTotal();
        return to>total?total:to;
    }
>>>>>>> 2965fdde98e956b8b636b00cee29f2367d6615b0
}
