# SpringBootCRUD
簡易CRUD範例
<hr>
<h3>URL使用Get事件範例</h3>
<ul>
<li>取得列表：http://localhost:8081/GetMyBooks</li>
<li>新增資料：http://localhost:8081/InsMyBooks?Title=測試&Price=50</li>
<li>修改資料：http://localhost:8081/UpdMyBooks?Id=24&Title=測試修改2&Price=88</li>
<li>刪除資料：http://localhost:8081/DelMyBooks?Id=24</li>
</ul>

<h3>Thymeleaf練習</h3>
<ul>
<li>http://localhost:8081/MyBooksPage</li>
</ul>


<h3>DB表格</h3>
<pre>
<code>
USE [MyTestDB]
GO
CREATE TABLE [dbo].[MyBooks](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nvarchar](max) NOT NULL,
	[Price] [decimal](18, 2) NOT NULL,
 CONSTRAINT [PK_dbo.MyBooks] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
</code>
</pre>
