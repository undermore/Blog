/*
数据库包含4个表
文章 article
主类别 maincategory
子类别 subcategory
用户 user
*/
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

--
-- 数据库： `blog`
--

-- --------------------------------------------------------

--
-- 文章表 `article`
--

CREATE TABLE `article` (
  `id` int(50) NOT NULL,  
  `title` varchar(500) NOT NULL,        /* 标题     */
  `subtitle` varchar(500) DEFAULT NULL, /* 子标题   */
  `name` varchar(500) DEFAULT NULL,     /* 作者名字 */
  `html_content` text DEFAULT NULL,     /* 内容     */
  `create_date` varchar(500) NOT NULL,  /* 创建时间 */
  `user_id` int(50) NOT NULL,           /* 作者id   */
  `cate_id` int(50) NOT NULL,           /* 主类别id */
  `sub_cate_id` int(50) NOT NULL        /* 子类别id */
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 插入一条数据 `article`
--

INSERT INTO `article` (`id`, `title`, `subtitle`, `name`, `html_content`, `create_date`, `user_id`, `cate_id`, `sub_cate_id`) VALUES
(1, '标题', '子标题', '作者', 'dfdf', '2018-04-24 03:13', 1, 1, 1);

-- --------------------------------------------------------

--
-- 主类别表 `maincategory`
--

CREATE TABLE `maincategory` (
  `id` int(50) NOT NULL,
  `name` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 插入一条数据 `maincategory`
--

INSERT INTO `maincategory` (`id`, `name`) VALUES
(1, 'main_1'),
(2, 'main_2');

-- --------------------------------------------------------

--
-- 子类别表 `subcategory`
--

CREATE TABLE `subcategory` (
  `id` int(50) NOT NULL,
  `name` varchar(500) NOT NULL,
  `cate_id` int(50) NOT NULL           /* 主类别id  */
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 插入一条数据 `subcategory`
--

INSERT INTO `subcategory` (`id`, `name`, `cate_id`) VALUES
(1, 'sub_2', 1);

-- --------------------------------------------------------

--
-- 用户表 `user`
--

CREATE TABLE `user` (
  `id` int(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 插入一条数据 `user`
--

INSERT INTO `user` (`id`, `username`, `password`) VALUES
(1, 'admin', '1111');


--
-- 表的索引 `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `cate_id` (`cate_id`),
  ADD KEY `sub_cate_id` (`sub_cate_id`);

--
-- 表的索引 `maincategory`
--
ALTER TABLE `maincategory`
  ADD PRIMARY KEY (`id`);

--
-- 表的索引 `subcategory`
--
ALTER TABLE `subcategory`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cate_id` (`cate_id`);

--
-- 表的索引 `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);


--
-- 使用表AUTO_INCREMENT `article`
--
ALTER TABLE `article`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 使用表AUTO_INCREMENT `maincategory`
--
ALTER TABLE `maincategory`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 使用表AUTO_INCREMENT `subcategory`
--
ALTER TABLE `subcategory`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 使用表AUTO_INCREMENT `user`
--
ALTER TABLE `user`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;


--
-- 限制表 `article`
--
ALTER TABLE `article`
  ADD CONSTRAINT `article_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `article_ibfk_2` FOREIGN KEY (`cate_id`) REFERENCES `maincategory` (`id`),
  ADD CONSTRAINT `article_ibfk_3` FOREIGN KEY (`sub_cate_id`) REFERENCES `subcategory` (`id`);

--
-- 限制表 `subcategory`
--
ALTER TABLE `subcategory`
  ADD CONSTRAINT `subcategory_ibfk_1` FOREIGN KEY (`cate_id`) REFERENCES `maincategory` (`id`);
COMMIT;
