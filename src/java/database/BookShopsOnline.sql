USE [master]
GO
/****** Object:  Database [BooksShopOnline]    Script Date: 3/3/2022 5:09:27 PM ******/
CREATE DATABASE [BooksShopOnline]
 CONTAINMENT = NONE
 ON  PRIMARY 
GO
ALTER DATABASE [BooksShopOnline] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BooksShopOnline].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [BooksShopOnline] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BooksShopOnline] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BooksShopOnline] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BooksShopOnline] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BooksShopOnline] SET ARITHABORT OFF 
GO
ALTER DATABASE [BooksShopOnline] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [BooksShopOnline] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BooksShopOnline] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BooksShopOnline] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BooksShopOnline] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BooksShopOnline] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BooksShopOnline] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BooksShopOnline] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BooksShopOnline] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BooksShopOnline] SET  DISABLE_BROKER 
GO
ALTER DATABASE [BooksShopOnline] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BooksShopOnline] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BooksShopOnline] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BooksShopOnline] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BooksShopOnline] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BooksShopOnline] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BooksShopOnline] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BooksShopOnline] SET RECOVERY FULL 
GO
ALTER DATABASE [BooksShopOnline] SET  MULTI_USER 
GO
ALTER DATABASE [BooksShopOnline] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BooksShopOnline] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BooksShopOnline] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BooksShopOnline] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [BooksShopOnline] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [BooksShopOnline] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'BooksShopOnline', N'ON'
GO
ALTER DATABASE [BooksShopOnline] SET QUERY_STORE = OFF
GO
USE [BooksShopOnline]
GO
/****** Object:  Table [dbo].[Accounts]    Script Date: 3/3/2022 5:09:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Accounts](
	[AccountID] [varchar](10) NOT NULL,
	[Username] [varchar](25) NOT NULL,
	[Password] [nvarchar](50) NULL,
	[Email] [varchar](50) NOT NULL,
	[Phone] [varchar](15) NULL,
	[Role] [varchar](10) NOT NULL,
	[Salt] [nvarchar](50) NULL,
 CONSTRAINT [PK_Accounts] PRIMARY KEY CLUSTERED 
(
	[AccountID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Authors]    Script Date: 3/3/2022 5:09:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Authors](
	[AuthorID] [varchar](10) NOT NULL,
	[AuthorName] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Authors] PRIMARY KEY CLUSTERED 
(
	[AuthorID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 3/3/2022 5:09:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[CategoryID] [varchar](10) NOT NULL,
	[CategoryName] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[CategoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customer]    Script Date: 3/3/2022 5:09:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[CustomerID] [varchar](10) NOT NULL,
	[AccountID] [varchar](10) NOT NULL,
	[CustomerName] [nvarchar](50) NOT NULL,
	[DOB] [date] NULL,
	[Address] [nvarchar](200) NOT NULL,
 CONSTRAINT [PK_Customer] PRIMARY KEY CLUSTERED 
(
	[CustomerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Feedback]    Script Date: 3/3/2022 5:09:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Feedback](
	[CustomerID] [varchar](10) NOT NULL,
	[FeedbackDate] [date] NOT NULL,
	[Description] [nvarchar](max) NULL,
	[ProductID] [varchar](10) NOT NULL,
	[Ratting] [tinyint] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 3/3/2022 5:09:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetail](
	[OrderID] [varchar](10) NOT NULL,
	[ProductID] [varchar](10) NOT NULL,
	[Quantity] [int] NOT NULL,
	[UnitPrice] [money] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 3/3/2022 5:09:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[OrderID] [varchar](10) NOT NULL,
	[CustomerID] [varchar](10) NOT NULL,
	[OrderDate] [date] NOT NULL,
	[Ship] [nvarchar](50) NULL,
	[Status] [nvarchar](50) NOT NULL,
	[PaymentMethod] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Orders] PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ProAu]    Script Date: 3/3/2022 5:09:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProAu](
	[ProductID] [varchar](10) NOT NULL,
	[AuthorID] [varchar](10) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 3/3/2022 5:09:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[ProductID] [varchar](10) NOT NULL,
	[ProductName] [nvarchar](50) NOT NULL,
	[ImagePath] [varchar](100) NOT NULL,
	[CreatedDate] [date] NOT NULL,
	[Description] [nvarchar](max) NOT NULL,
	[UnitPrice] [money] NOT NULL,
	[UnitInStock] [int] NOT NULL,
	[IsContinue] [bit] NOT NULL,
	[Ratting] [tinyint] NULL,
	[CategoryID] [varchar](10) NOT NULL,
 CONSTRAINT [PK_Products] PRIMARY KEY CLUSTERED 
(
	[ProductID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Reports]    Script Date: 3/3/2022 5:09:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Reports](
	[ReportID] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nvarchar](50) NULL,
	[CustomerName] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
	[Phone] [nvarchar](50) NULL,
	[Insurance] [nvarchar](50) NULL,
	[Descriptions] [nvarchar](50) NULL,
	[Status] [nvarchar](50) NULL,
	[AccountID] [varchar](10) NULL,
	[Time] [date] NULL,
 CONSTRAINT [PK_Reports] PRIMARY KEY CLUSTERED 
(
	[ReportID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'1', N'minhvu', N'2d00fde196884cbfd731ba1ff54d79e9', N'minmin@gmail.com', N'1234567891', N'1', N'BbLUGtTdfLUUuDMgJyg76Q==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'HE1', N'vuhoctrothaysang', N'fb5e0a6776da45863e60195c913b8ce5', N'vudmhe140017@fpt.edu.vn', N'0818180399', N'1', N'q6V/N2RqfCdUPYhcvMHMNA==')
GO
INSERT [dbo].[Authors] ([AuthorID], [AuthorName]) VALUES (N'1', N'J.K Rowling')
INSERT [dbo].[Authors] ([AuthorID], [AuthorName]) VALUES (N'2', N'J.K Rowling')
INSERT [dbo].[Authors] ([AuthorID], [AuthorName]) VALUES (N'3', N'To Hoai')
INSERT [dbo].[Authors] ([AuthorID], [AuthorName]) VALUES (N'4', N'Clare Chase')
GO
INSERT [dbo].[Category] ([CategoryID], [CategoryName]) VALUES (N'1', N'Story')
INSERT [dbo].[Category] ([CategoryID], [CategoryName]) VALUES (N'2', N'Book')
INSERT [dbo].[Category] ([CategoryID], [CategoryName]) VALUES (N'3', N'Novel')
GO
INSERT [dbo].[ProAu] ([ProductID], [AuthorID]) VALUES (N'1', N'1')
INSERT [dbo].[ProAu] ([ProductID], [AuthorID]) VALUES (N'2', N'2')
INSERT [dbo].[ProAu] ([ProductID], [AuthorID]) VALUES (N'3', N'3')
INSERT [dbo].[ProAu] ([ProductID], [AuthorID]) VALUES (N'4', N'4')
GO
INSERT [dbo].[Products] ([ProductID], [ProductName], [ImagePath], [CreatedDate], [Description], [UnitPrice], [UnitInStock], [IsContinue], [Ratting], [CategoryID]) VALUES (N'1', N'Harry Potter', N'./public/image/b.png', CAST(N'2022-01-18' AS Date), N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 10.0000, 20, 1, 2, N'1')
INSERT [dbo].[Products] ([ProductID], [ProductName], [ImagePath], [CreatedDate], [Description], [UnitPrice], [UnitInStock], [IsContinue], [Ratting], [CategoryID]) VALUES (N'2', N'Harry Potter2', N'./public/image/hp2.png', CAST(N'2022-01-17' AS Date), N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 20.0000, 30, 1, 3, N'1')
INSERT [dbo].[Products] ([ProductID], [ProductName], [ImagePath], [CreatedDate], [Description], [UnitPrice], [UnitInStock], [IsContinue], [Ratting], [CategoryID]) VALUES (N'3', N'De Men Phuu Luu Ky', N'./public/image/demen.jpg', CAST(N'2022-01-20' AS Date), N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 30.0000, 10, 1, 4, N'2')
INSERT [dbo].[Products] ([ProductID], [ProductName], [ImagePath], [CreatedDate], [Description], [UnitPrice], [UnitInStock], [IsContinue], [Ratting], [CategoryID]) VALUES (N'4', N'Death Comes To Call', N'./public/image/death.jpg', CAST(N'2022-02-05' AS Date), N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 50.0000, 15, 1, 5, N'3')
GO
SET IDENTITY_INSERT [dbo].[Reports] ON 

INSERT [dbo].[Reports] ([ReportID], [Title], [CustomerName], [Email], [Phone], [Insurance], [Descriptions], [Status], [AccountID], [Time]) VALUES (2, N'dfa', N'sda', N'sad', N'sad', N'sad', N'asd', N'pending', N'1', CAST(N'2022-03-02' AS Date))
INSERT [dbo].[Reports] ([ReportID], [Title], [CustomerName], [Email], [Phone], [Insurance], [Descriptions], [Status], [AccountID], [Time]) VALUES (3, N'mmin', N'min', N'min', N'min', N'val2', N'wweqwe', N'pending', N'1', CAST(N'2022-03-02' AS Date))
INSERT [dbo].[Reports] ([ReportID], [Title], [CustomerName], [Email], [Phone], [Insurance], [Descriptions], [Status], [AccountID], [Time]) VALUES (4, N'asA', N'ASDSA', N'SAD', N'asda', N'1 year', N'sad', N'pending', N'1', CAST(N'2022-03-02' AS Date))
SET IDENTITY_INSERT [dbo].[Reports] OFF
GO
ALTER TABLE [dbo].[Customer]  WITH CHECK ADD  CONSTRAINT [FK_Customer_Accounts] FOREIGN KEY([AccountID])
REFERENCES [dbo].[Accounts] ([AccountID])
GO
ALTER TABLE [dbo].[Customer] CHECK CONSTRAINT [FK_Customer_Accounts]
GO
ALTER TABLE [dbo].[Feedback]  WITH CHECK ADD  CONSTRAINT [FK_Feedback_Customer] FOREIGN KEY([CustomerID])
REFERENCES [dbo].[Customer] ([CustomerID])
GO
ALTER TABLE [dbo].[Feedback] CHECK CONSTRAINT [FK_Feedback_Customer]
GO
ALTER TABLE [dbo].[Feedback]  WITH CHECK ADD  CONSTRAINT [FK_Feedback_Products] FOREIGN KEY([ProductID])
REFERENCES [dbo].[Products] ([ProductID])
GO
ALTER TABLE [dbo].[Feedback] CHECK CONSTRAINT [FK_Feedback_Products]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_Orders] FOREIGN KEY([OrderID])
REFERENCES [dbo].[Orders] ([OrderID])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK_OrderDetail_Orders]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_Products] FOREIGN KEY([ProductID])
REFERENCES [dbo].[Products] ([ProductID])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK_OrderDetail_Products]
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD  CONSTRAINT [FK_Orders_Customer] FOREIGN KEY([CustomerID])
REFERENCES [dbo].[Customer] ([CustomerID])
GO
ALTER TABLE [dbo].[Orders] CHECK CONSTRAINT [FK_Orders_Customer]
GO
ALTER TABLE [dbo].[ProAu]  WITH CHECK ADD  CONSTRAINT [FK_ProAu_Authors] FOREIGN KEY([AuthorID])
REFERENCES [dbo].[Authors] ([AuthorID])
GO
ALTER TABLE [dbo].[ProAu] CHECK CONSTRAINT [FK_ProAu_Authors]
GO
ALTER TABLE [dbo].[ProAu]  WITH CHECK ADD  CONSTRAINT [FK_ProAu_Products] FOREIGN KEY([ProductID])
REFERENCES [dbo].[Products] ([ProductID])
GO
ALTER TABLE [dbo].[ProAu] CHECK CONSTRAINT [FK_ProAu_Products]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_Products_Category] FOREIGN KEY([CategoryID])
REFERENCES [dbo].[Category] ([CategoryID])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Products_Category]
GO
ALTER TABLE [dbo].[Reports]  WITH CHECK ADD  CONSTRAINT [FK_Reports_Accounts] FOREIGN KEY([AccountID])
REFERENCES [dbo].[Accounts] ([AccountID])
GO
ALTER TABLE [dbo].[Reports] CHECK CONSTRAINT [FK_Reports_Accounts]
GO
USE [master]
GO
ALTER DATABASE [BooksShopOnline] SET  READ_WRITE 
GO