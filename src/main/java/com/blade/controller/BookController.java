package com.blade.controller;

import com.alibaba.fastjson.JSONObject;
import com.blade.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

/**
 * 图书controller
 */
@Controller
@RequestMapping("books")
public class BookController {
    @RequestMapping
    public String index(Model model) {
        model.addAttribute("bookList", Arrays.asList(
                new Book(1, "卖火柴的小女孩", 88.8),
                new Book(2, "丑小鸭", 99.9),
                new Book(3, "如何让台湾优雅的回归", 123.4)
                )
        );

        return "book-list";
    }

    /**
     * rest风格的web接口
     */
    @RequestMapping(value = "/book/{bookId}")
    @ResponseBody
    public Object displayBook(@PathVariable String bookId) {
        JSONObject bookInfoJson = new JSONObject();
        bookInfoJson.put("result", "fail");

        if (bookId.equals("2")) {
            bookInfoJson.put("result", "success");
            bookInfoJson.put("bookName", "丑小鸭");
            bookInfoJson.put("content", "乡下真是非常美丽。这正是夏天！小麦是金黄的，燕麦是绿油油的。" +
                    "干草在绿色的牧场上堆成垛，鹳鸟用它又长又红的退子在散着步，噜嗦地讲着埃及话。" +
                    "（注：因为据丹麦的民间传说，鹳鸟是从埃及飞来的。）这是它从妈妈那儿学到的一种语言。" +
                    "田野和牧场的周围有些大森林，森林里有些很深的池塘。的确，乡间是非常美丽的，" +
                    "太阳光正照着一幢老式的房子，它周围流着几条很深的小溪。从墙角那儿一直到水里，全" +
                    "盖满了牛蒡的大叶子。最大的叶子长得非常高，小孩子简直可以直着腰站在下面。像在最浓密" +
                    "的森林里一样，这儿也是很荒凉的。这儿有一只母鸭坐在窠里，她得把她的几个小鸭都孵出来。" +
                    "不过这时她已经累坏了。很少有客人来看她。别的鸭子都愿意在溪流里游来游去，而不愿意跑到牛蒡" +
                    "下面来和她聊天。\n" +
                    "最后，那些鸭蛋一个接着一个地崩开了。“噼！噼！”蛋壳响起来。所有的蛋黄现在都变成了小动物。" +
                    "他们把小头都伸出来。\n" +
                    "“嘎！嘎！”母鸭说。他们也就跟着嘎嘎地大声叫起来。他们在绿叶子下面向四周看。妈妈让他们尽量" +
                    "地东张西望，因为绿色对他们的眼睛是有好处的。\n" +
                    "“这个世界真够大！”这些年轻的小家伙说。的确，比起他们在蛋壳里的时候，他们现在的天地真是大不相同了。\n" +
                    "“你们以为这就是整个世界！”妈妈说。“这地方伸展到花园的另一边，一直伸展到牧师的田里去，" +
                    "才远呢！连我自己都没有去过！我想你们都在这儿吧？”她站起来。“没有，我还没有把你们都生出来呢！" +
                    "这只顶大的蛋还躺着没有动静。它还得躺多久呢？我真是有些烦了。”于是她又坐下来。\n" +
                    "“唔，情形怎样？”一只来拜访她的老鸭子问。\n" +
                    "“这个蛋费的时间真久！”坐着的母鸭说。“它老是不裂开。请你看看别的吧。他们真是一些最逗人爱" +
                    "的小鸭儿！都像他们的爸爸——这个坏东西从来没有来看过我一次！”");
         }

        return bookInfoJson;
    }
}
