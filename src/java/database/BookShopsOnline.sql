USE [master]
GO
/****** Object:  Database [BookShopsOnline]    Script Date: 3/27/2022 11:18:04 PM ******/
CREATE DATABASE [BookShopsOnline]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'BookShopsOnline', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MINHVU\MSSQL\DATA\BookShopsOnline.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'BookShopsOnline_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MINHVU\MSSQL\DATA\BookShopsOnline_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [BookShopsOnline] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BookShopsOnline].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [BookShopsOnline] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BookShopsOnline] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BookShopsOnline] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BookShopsOnline] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BookShopsOnline] SET ARITHABORT OFF 
GO
ALTER DATABASE [BookShopsOnline] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [BookShopsOnline] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BookShopsOnline] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BookShopsOnline] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BookShopsOnline] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BookShopsOnline] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BookShopsOnline] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BookShopsOnline] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BookShopsOnline] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BookShopsOnline] SET  DISABLE_BROKER 
GO
ALTER DATABASE [BookShopsOnline] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BookShopsOnline] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BookShopsOnline] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BookShopsOnline] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BookShopsOnline] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BookShopsOnline] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BookShopsOnline] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BookShopsOnline] SET RECOVERY FULL 
GO
ALTER DATABASE [BookShopsOnline] SET  MULTI_USER 
GO
ALTER DATABASE [BookShopsOnline] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BookShopsOnline] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BookShopsOnline] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BookShopsOnline] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [BookShopsOnline] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [BookShopsOnline] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'BookShopsOnline', N'ON'
GO
ALTER DATABASE [BookShopsOnline] SET QUERY_STORE = OFF
GO
USE [BookShopsOnline]
GO
/****** Object:  Table [dbo].[Accounts]    Script Date: 3/27/2022 11:18:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Accounts](
	[AccountID] [varchar](10) NOT NULL,
	[Username] [varchar](25) NOT NULL,
	[Password] [varchar](50) NOT NULL,
	[Email] [varchar](50) NOT NULL,
	[Phone] [varchar](15) NULL,
	[Role] [varchar](10) NOT NULL,
	[Salt] [varchar](24) NULL,
 CONSTRAINT [PK_Accounts] PRIMARY KEY CLUSTERED 
(
	[AccountID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Authors]    Script Date: 3/27/2022 11:18:04 PM ******/
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
/****** Object:  Table [dbo].[Category]    Script Date: 3/27/2022 11:18:04 PM ******/
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
/****** Object:  Table [dbo].[Customer]    Script Date: 3/27/2022 11:18:04 PM ******/
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
/****** Object:  Table [dbo].[Discount]    Script Date: 3/27/2022 11:18:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Discount](
	[DiscountID] [int] IDENTITY(1,1) NOT NULL,
	[DiscountCODE] [varchar](255) NULL,
	[CustomerID] [varchar](10) NULL,
	[ProductID] [varchar](10) NULL,
	[IsContinue] [int] NULL,
	[DiscountValue] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[DiscountID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Feedback]    Script Date: 3/27/2022 11:18:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Feedback](
	[CustomerID] [varchar](10) NOT NULL,
	[FeedbackDate] [date] NOT NULL,
	[Description] [nchar](10) NOT NULL,
	[ProductID] [varchar](10) NOT NULL,
	[Ratting] [tinyint] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 3/27/2022 11:18:04 PM ******/
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
/****** Object:  Table [dbo].[Orders]    Script Date: 3/27/2022 11:18:04 PM ******/
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
/****** Object:  Table [dbo].[ProAu]    Script Date: 3/27/2022 11:18:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProAu](
	[ProductID] [varchar](10) NOT NULL,
	[AuthorID] [varchar](10) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 3/27/2022 11:18:04 PM ******/
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
/****** Object:  Table [dbo].[Reports]    Script Date: 3/27/2022 11:18:04 PM ******/
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
/****** Object:  Table [dbo].[SalesPartner]    Script Date: 3/27/2022 11:18:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SalesPartner](
	[PartnerID] [int] IDENTITY(1,1) NOT NULL,
	[PartnerName] [nvarchar](50) NULL,
	[Address] [nvarchar](50) NULL,
	[Product] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
	[Phone] [nvarchar](50) NULL,
	[Description] [nvarchar](50) NULL,
	[Status] [nvarchar](50) NULL,
 CONSTRAINT [PK_SalesPartner] PRIMARY KEY CLUSTERED 
(
	[PartnerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC0', N'admin', N'53b94fcab1fe0b540cc7eadd982a2049', N'etiam.ligula@google.edu', N'0598237542', N'admin', N'tTylfYbZNrJEPHafqVJ/MA==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC1', N'user1', N'2bcfde759f6e29cda1d6edef4c88dd7d', N'in@aol.edu', N'0692712181', N'user', N'raMzuFRpK/DbMKDWH4zvxA==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC10', N'user10', N'86f29094528334009acbea275b37f91b', N'donec.tincidunt.donec@aol.ca', N'0422427536', N'user', N'YXAfCh0T65nMINnuii5MSQ==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC11', N'user11', N'f6b8f5042f802fee39ecfed8cf893314', N'velit.dui.semper@hotmail.edu', N'0626274184', N'user', N'szl/3C4Qvloaz7xa2/oH7g==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC12', N'user12', N'6f310f64cc4609c310f3e455c8fbd6e0', N'sociis.natoque@aol.ca', N'0437623203', N'user', N'NmKl8Eqv/PVR9qQlB8Kh+A==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC13', N'user13', N'd9faa5c8bc11fdfc6bcef27131b3f524', N'pede.cras.vulputate@outlook.ca', N'0463748155', N'user', N'pv4p18ov+y6aJSFmu1j3WA==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC14', N'user14', N'af2f90563562aea89ee4b19f1b47e33a', N'a.ultricies.adipiscing@google.net', N'0717464905', N'user', N'qAX2idjZ+7/lZl+ptQ/Qdw==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC15', N'user15', N'974f38eb92dd6c31d1e9cf0e902f0c06', N'libero@outlook.com', N'0880801095', N'user', N'SCi+VKLvoW37n1gOTwvhJQ==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC16', N'user16', N'd3ff56bb109910aab9a7b15e02f22593', N'enim.mi@outlook.net', N'0874333535', N'user', N'NPSxkTKhohez7mCDOzyv4g==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC17', N'user17', N'b9fc72988683239285a521cce247c412', N'integer@outlook.edu', N'0270464500', N'user', N'wMLm7sUpt6PfhKdUG18jyg==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC18', N'user18', N'7968c678e01636a0ec8f6d0aae71db55', N'amet@yahoo.couk', N'0562803925', N'user', N'2qC6J17A2tCEWjp13lFm0Q==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC19', N'user19', N'6b3aac6ed49309862ccaaba594a7ae78', N'ac.turpis.egestas@outlook.ca', N'0507487227', N'user', N'1KrM7Cs+0QAy8B1m2XNDyA==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC2', N'user2', N'242dac5cc767a5aa56a74f42a99a5176', N'non.enim@aol.edu', N'0334086275', N'user', N'az6cD231mWZ3uqZ6wFV2lQ==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC20', N'user20', N'52404389154dc488a47cea044f7cf5aa', N'magna.malesuada@aol.org', N'0455811669', N'user', N'LSGMfPGiaN44Wye9taTlMw==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC21', N'user21', N'0826937b1055981e4ff193d385e967c0', N'non.sapien@hotmail.org', N'0542174247', N'user', N'l5x3mmCYKgC5eQOUQKuHFQ==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC22', N'user22', N'acd0c988d094bc994e841485e021ae09', N'nam.consequat@hotmail.couk', N'0480368315', N'user', N'0pU6df5UFI1xVqqxpmEHhg==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC23', N'user23', N'1b7e18270e6681675b0be13c7cc57ee1', N'luctus.et.ultrices@protonmail.edu', N'0144144588', N'user', N'mCemn7oQ11NMMARPahz5wg==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC24', N'user24', N'0f55ea015196132adb74165e53f06c60', N'commodo@icloud.net', N'0819167671', N'user', N'9soGPG8rtVM/B8eVaUjLqA==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC25', N'user25', N'8dcb9bf515ee4db3706fe8ba111c9861', N'nunc@google.com', N'0561702861', N'user', N'bsLgbrrHbxPQKbBM2HlMgQ==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC26', N'user26', N'f526cb58f88113d5ec74ae62a304f7cd', N'eget@google.org', N'0860385824', N'user', N'nSV1r0gQT/Al039jl5+fHg==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC27', N'user27', N'dec90927ba9863774c5ff430ebfa8d7e', N'eu.tellus@outlook.com', N'0521083479', N'user', N'SHTWdce2PmFpOMos4GW5iw==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC28', N'user28', N'e921dcf279a2da465314e18683d890d2', N'pede.praesent@outlook.com', N'0335035917', N'user', N'+IGa9gPkYuISvJbtzRIDVw==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC29', N'user29', N'94509cf276eca0c074e15a0c5ba1df64', N'sed.nulla.ante@yahoo.ca', N'0330525189', N'user', N'Bpk3mKaKiAmF2JD/UKGP1w==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC3', N'user3', N'e43f704382ee082a7454a0ad20639216', N'mauris.eu@yahoo.ca', N'0775265163', N'user', N'YivWPooeKVi/GTEG7Cj66Q==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC30', N'user30', N'5872f09fb67b38a20f8b49e69e8e5ebb', N'fusce.feugiat.lorem@protonmail.ca', N'0338035136', N'user', N'jC/4dfCebNlcjwnm0AekzA==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC31', N'user31', N'4d802782b381418faddd3e640780b70a', N'vel@google.com', N'0333192301', N'user', N'HW8R6YfIxblEMtuKBx07pg==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC32', N'user32', N'652ac3ffc1d982836317a3ce594eb51e', N'maecenas.mi@google.couk', N'0368244011', N'user', N'rhoc344Pnq6Wrh3qa+1djg==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC33', N'user33', N'fe6b59e1eac5459bd5f9c9c34d0358dd', N'urna.nullam@hotmail.org', N'0961433141', N'user', N'225inuWIsA+U3UdKxYfnvw==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC34', N'user34', N'65f67e4bcba04ade85f4c4fa66cd1a1c', N'tellus.justo.sit@hotmail.net', N'0678297632', N'user', N'1TLxOWXaxjKHqKo5coYrqg==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC35', N'user35', N'af4b83108c9846f98b668324619bc61c', N'quis.turpis@protonmail.org', N'0632806768', N'user', N'64jKc7Kf7wM4SMtauKq3jg==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC36', N'user36', N'e989f872d758e6f30a7c1fce850b568a', N'fusce.mollis.duis@outlook.couk', N'0249966121', N'user', N'wqlsTl4Z/CL6Ju7Ej1ohBw==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC37', N'user37', N'edde29b80fad9cf85d3b803d1eb6621b', N'mauris.eu@icloud.net', N'0154727483', N'user', N'ZlQUAzb1ZtgaXjPHuQ+RnQ==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC38', N'user38', N'5630eee403bd82994368c5945888a7f7', N'nulla.interdum.curabitur@aol.ca', N'0853164970', N'user', N'wjCmw797Ej9Oif9WNbZBxA==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC39', N'user39', N'0f8a2906c14a545783539684e47153b2', N'', N'0798435345', N'user', N'6wt8+HP7ti4lbiTCc+F4tQ==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC4', N'user4', N'119b6d04d56271ddd33e6563574b7184', N'metus.in@outlook.net', N'0888496543', N'user', N'wk8vW6YNRUcRUobjeiXKSA==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC5', N'user5', N'2f6373671bddd8a258b7519ef0839552', N'nisl@hotmail.edu', N'0710546267', N'user', N'hzY2rWXAx+FeCvIG2Fk+vQ==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC6', N'user6', N'd85402700f628424e12c3df4e3131328', N'enim.sed@protonmail.org', N'0869913062', N'user', N'btenQo6RakNkPiDh0oopZQ==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC7', N'user7', N'875199b678c5397a38671765dd0f6ad4', N'et@icloud.ca', N'0350226579', N'user', N'/ozLpO9ylthg1sMsVb+Ewg==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'Acc73192', N'minhvu', N'e54cd990afe00ac91f3599d69b288c20', N'vudmhe140017@fpt.edu.vn', N'0818180399', N'admin', N'72QiANEyiLA8Xpa/mMSRFA==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC8', N'user8', N'584cafa8846438247a7a2ca9b3f537ef', N'pellentesque.tellus@aol.org', N'0758533495', N'user', N'IMOX7xK5DKptzh3/HIZEbA==')
INSERT [dbo].[Accounts] ([AccountID], [Username], [Password], [Email], [Phone], [Role], [Salt]) VALUES (N'ACC9', N'user9', N'10880515b8f34c60b6cd881abfacd82b', N'arcu.sed@google.com', N'0821753814', N'user', N'laFN6ifia9KT01W2n32rnQ==')
GO
INSERT [dbo].[Authors] ([AuthorID], [AuthorName]) VALUES (N'AU1', N'Nikole Hannah-Jones')
INSERT [dbo].[Authors] ([AuthorID], [AuthorName]) VALUES (N'AU2', N'Victor Miller')
INSERT [dbo].[Authors] ([AuthorID], [AuthorName]) VALUES (N'AU3', N'Emi Aguilar')
INSERT [dbo].[Authors] ([AuthorID], [AuthorName]) VALUES (N'AU4', N'Kuame Kemp')
INSERT [dbo].[Authors] ([AuthorID], [AuthorName]) VALUES (N'AU5', N'Mia Dawson')
INSERT [dbo].[Authors] ([AuthorID], [AuthorName]) VALUES (N'AU6', N'Katell Daniel')
GO
INSERT [dbo].[Category] ([CategoryID], [CategoryName]) VALUES (N'CAT1', N'Novel')
INSERT [dbo].[Category] ([CategoryID], [CategoryName]) VALUES (N'CAT2', N'Dictionary')
INSERT [dbo].[Category] ([CategoryID], [CategoryName]) VALUES (N'CAT3', N'Drama')
INSERT [dbo].[Category] ([CategoryID], [CategoryName]) VALUES (N'CAT4', N'Fantasy')
INSERT [dbo].[Category] ([CategoryID], [CategoryName]) VALUES (N'CAT5', N'Cookbook')
GO
INSERT [dbo].[Customer] ([CustomerID], [AccountID], [CustomerName], [DOB], [Address]) VALUES (N'CUS1', N'ACC19', N'Pascale Watson', CAST(N'2000-08-28' AS Date), N'Ap #127-7105 Auctor St.')
INSERT [dbo].[Customer] ([CustomerID], [AccountID], [CustomerName], [DOB], [Address]) VALUES (N'CUS10', N'ACC33', N'Fay Roberts', CAST(N'1986-05-25' AS Date), N'P.O. Box 205, 2537 Montes, Rd.')
INSERT [dbo].[Customer] ([CustomerID], [AccountID], [CustomerName], [DOB], [Address]) VALUES (N'CUS11', N'ACC15', N'Samuel Wilkinson', CAST(N'2000-11-02' AS Date), N'Ap #782-4717 Hendrerit Road')
INSERT [dbo].[Customer] ([CustomerID], [AccountID], [CustomerName], [DOB], [Address]) VALUES (N'CUS12', N'ACC23', N'Hanna Bradford', CAST(N'2000-07-12' AS Date), N'Ap #417-6441 Mattis Avenue')
INSERT [dbo].[Customer] ([CustomerID], [AccountID], [CustomerName], [DOB], [Address]) VALUES (N'CUS13', N'ACC35', N'Delilah Bridges', CAST(N'1998-01-22' AS Date), N'Ap #852-5341 Id, St.')
INSERT [dbo].[Customer] ([CustomerID], [AccountID], [CustomerName], [DOB], [Address]) VALUES (N'CUS14', N'ACC24', N'Ira Edwards', CAST(N'2002-07-21' AS Date), N'Ap #801-6784 Sociis St.')
INSERT [dbo].[Customer] ([CustomerID], [AccountID], [CustomerName], [DOB], [Address]) VALUES (N'CUS15', N'ACC4', N'Beatrice Leach', CAST(N'2001-09-18' AS Date), N'6607 Arcu St.')
INSERT [dbo].[Customer] ([CustomerID], [AccountID], [CustomerName], [DOB], [Address]) VALUES (N'CUS16', N'ACC31', N'Allegra Lee', CAST(N'2003-04-16' AS Date), N'Ap #152-4042 Sagittis Road')
INSERT [dbo].[Customer] ([CustomerID], [AccountID], [CustomerName], [DOB], [Address]) VALUES (N'CUS17', N'ACC25', N'Candice Fleming', CAST(N'1990-07-12' AS Date), N'P.O. Box 443, 6529 Purus. Road')
INSERT [dbo].[Customer] ([CustomerID], [AccountID], [CustomerName], [DOB], [Address]) VALUES (N'CUS18', N'ACC34', N'Zenaida Cameron', CAST(N'1990-12-13' AS Date), N'Ap #445-732 Sagittis Ave')
INSERT [dbo].[Customer] ([CustomerID], [AccountID], [CustomerName], [DOB], [Address]) VALUES (N'CUS19', N'ACC28', N'Harrison Payne', CAST(N'1998-10-06' AS Date), N'Ap #143-9012 Maecenas Rd.')
INSERT [dbo].[Customer] ([CustomerID], [AccountID], [CustomerName], [DOB], [Address]) VALUES (N'CUS2', N'ACC22', N'Molly Grimes', CAST(N'2003-10-13' AS Date), N'250-5395 Sem Av.')
INSERT [dbo].[Customer] ([CustomerID], [AccountID], [CustomerName], [DOB], [Address]) VALUES (N'CUS20', N'ACC38', N'Cora Harvey', CAST(N'1992-01-24' AS Date), N'130-6624 Dolor Rd.')
INSERT [dbo].[Customer] ([CustomerID], [AccountID], [CustomerName], [DOB], [Address]) VALUES (N'CUS21', N'ACC29', N'Jillian Evans', CAST(N'2003-09-18' AS Date), N'9145 Rhoncus. Rd.')
INSERT [dbo].[Customer] ([CustomerID], [AccountID], [CustomerName], [DOB], [Address]) VALUES (N'CUS22', N'ACC3', N'Castor Schneider', CAST(N'1996-01-09' AS Date), N'813-435 Ridiculus Rd.')
INSERT [dbo].[Customer] ([CustomerID], [AccountID], [CustomerName], [DOB], [Address]) VALUES (N'CUS23', N'ACC39', N'Christen Ayala', CAST(N'1999-09-25' AS Date), N'429-1213 Et Rd.')
INSERT [dbo].[Customer] ([CustomerID], [AccountID], [CustomerName], [DOB], [Address]) VALUES (N'CUS24', N'ACC13', N'Leonard Mitchell', CAST(N'2000-12-21' AS Date), N'3677 Ligula. Ave')
INSERT [dbo].[Customer] ([CustomerID], [AccountID], [CustomerName], [DOB], [Address]) VALUES (N'CUS25', N'ACC18', N'Madison Morin', CAST(N'1997-11-03' AS Date), N'536-4792 Euismod St.')
INSERT [dbo].[Customer] ([CustomerID], [AccountID], [CustomerName], [DOB], [Address]) VALUES (N'CUS26', N'ACC1', N'user1', NULL, N'gg')
INSERT [dbo].[Customer] ([CustomerID], [AccountID], [CustomerName], [DOB], [Address]) VALUES (N'CUS3', N'ACC21', N'Tasha Carroll', CAST(N'1991-01-20' AS Date), N'123-7631 Sem, Road')
INSERT [dbo].[Customer] ([CustomerID], [AccountID], [CustomerName], [DOB], [Address]) VALUES (N'CUS4', N'ACC14', N'James Bell', CAST(N'1993-05-03' AS Date), N'322-2183 Eget, St.')
INSERT [dbo].[Customer] ([CustomerID], [AccountID], [CustomerName], [DOB], [Address]) VALUES (N'CUS5', N'ACC16', N'Coby Wyatt', CAST(N'1993-04-17' AS Date), N'P.O. Box 196, 3865 Eu Rd.')
INSERT [dbo].[Customer] ([CustomerID], [AccountID], [CustomerName], [DOB], [Address]) VALUES (N'CUS6', N'ACC36', N'Norman Morrison', CAST(N'1993-01-24' AS Date), N'Ap #173-2223 Eu Rd.')
INSERT [dbo].[Customer] ([CustomerID], [AccountID], [CustomerName], [DOB], [Address]) VALUES (N'CUS7', N'ACC26', N'Xenos James', CAST(N'1989-11-09' AS Date), N'Ap #178-2639 Ut Rd.')
INSERT [dbo].[Customer] ([CustomerID], [AccountID], [CustomerName], [DOB], [Address]) VALUES (N'CUS8', N'ACC30', N'Cally Burt', CAST(N'2000-12-23' AS Date), N'766-7024 Id Avenue')
INSERT [dbo].[Customer] ([CustomerID], [AccountID], [CustomerName], [DOB], [Address]) VALUES (N'CUS9', N'ACC7', N'Kyle Sheppard', CAST(N'2002-07-29' AS Date), N'5740 Elit. Avenue')
GO
INSERT [dbo].[OrderDetail] ([OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (N'OD1', N'PD11', 3, 50.0000)
INSERT [dbo].[OrderDetail] ([OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (N'OD1', N'PD10', 3, 50.0000)
INSERT [dbo].[OrderDetail] ([OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (N'OD1', N'PD7', 3, 52.0000)
INSERT [dbo].[OrderDetail] ([OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (N'OD2', N'PD9', 3, 81.0000)
INSERT [dbo].[OrderDetail] ([OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (N'OD2', N'PD7', 3, 52.0000)
INSERT [dbo].[OrderDetail] ([OrderID], [ProductID], [Quantity], [UnitPrice]) VALUES (N'OD2', N'PD8', 3, 46.0000)
GO
INSERT [dbo].[Orders] ([OrderID], [CustomerID], [OrderDate], [Ship], [Status], [PaymentMethod]) VALUES (N'OD1', N'CUS26', CAST(N'2022-03-27' AS Date), N'0', N'Waitting', N'Cash')
INSERT [dbo].[Orders] ([OrderID], [CustomerID], [OrderDate], [Ship], [Status], [PaymentMethod]) VALUES (N'OD2', N'CUS26', CAST(N'2022-03-27' AS Date), N'0', N'Waitting', N'Cash')
GO
INSERT [dbo].[ProAu] ([ProductID], [AuthorID]) VALUES (N'PD1', N'AU1')
INSERT [dbo].[ProAu] ([ProductID], [AuthorID]) VALUES (N'PD2', N'AU1')
INSERT [dbo].[ProAu] ([ProductID], [AuthorID]) VALUES (N'PD3', N'AU3')
INSERT [dbo].[ProAu] ([ProductID], [AuthorID]) VALUES (N'PD4', N'AU2')
INSERT [dbo].[ProAu] ([ProductID], [AuthorID]) VALUES (N'PD5', N'AU6')
INSERT [dbo].[ProAu] ([ProductID], [AuthorID]) VALUES (N'PD6', N'AU4')
INSERT [dbo].[ProAu] ([ProductID], [AuthorID]) VALUES (N'PD7', N'AU5')
INSERT [dbo].[ProAu] ([ProductID], [AuthorID]) VALUES (N'PD8', N'AU3')
INSERT [dbo].[ProAu] ([ProductID], [AuthorID]) VALUES (N'PD9', N'AU5')
INSERT [dbo].[ProAu] ([ProductID], [AuthorID]) VALUES (N'PD10', N'AU6')
INSERT [dbo].[ProAu] ([ProductID], [AuthorID]) VALUES (N'PD11', N'AU2')
INSERT [dbo].[ProAu] ([ProductID], [AuthorID]) VALUES (N'PD12', N'AU3')
INSERT [dbo].[ProAu] ([ProductID], [AuthorID]) VALUES (N'PD13', N'AU4')
GO
INSERT [dbo].[Products] ([ProductID], [ProductName], [ImagePath], [CreatedDate], [Description], [UnitPrice], [UnitInStock], [IsContinue], [Ratting], [CategoryID]) VALUES (N'PD1', N'The 1619 Project: A New Origin Story', N'./public/image/9780593230572.webp', CAST(N'1993-05-03' AS Date), N'#1 NEW YORK TIMES BESTSELLER - NAACP IMAGE AWARD WINNER - A dramatic expansion of a groundbreaking work of journalism, The 1619 Project: A New Origin Story offers a profoundly revealing vision of the American past and present.', 40.0000, 999, 1, 3, N'CAT1')
INSERT [dbo].[Products] ([ProductID], [ProductName], [ImagePath], [CreatedDate], [Description], [UnitPrice], [UnitInStock], [IsContinue], [Ratting], [CategoryID]) VALUES (N'PD10', N'The Subtweet', N'./public/image/9781770415256.webp', CAST(N'1990-09-01' AS Date), N'Celebrated multidisciplinary artist Vivek Shrayas second novel is a no-holds-barred examination of the music industry, social media, and making art in the modern era, shining a light on the promise and peril of being seen.', 50.0000, 999, 1, 3, N'CAT4')
INSERT [dbo].[Products] ([ProductID], [ProductName], [ImagePath], [CreatedDate], [Description], [UnitPrice], [UnitInStock], [IsContinue], [Ratting], [CategoryID]) VALUES (N'PD11', N'Pet', N'./public/image/9780593175446.jpg', CAST(N'2017-08-15' AS Date), N'NATIONAL BOOK AWARD FINALIST - STONEWALL BOOK AWARD WINNER - ONE OF TIME MAGAZINES 100 BEST YA BOOKS OF ALL TIME ', 50.0000, 999, 1, 3, N'CAT4')
INSERT [dbo].[Products] ([ProductID], [ProductName], [ImagePath], [CreatedDate], [Description], [UnitPrice], [UnitInStock], [IsContinue], [Ratting], [CategoryID]) VALUES (N'PD12', N'Bitter', N'./public/image/9780593309032.webp', CAST(N'2021-02-15' AS Date), N'From National Book Award finalist Akwaeke Emezi comes a companion novel to the critically acclaimed PET that explores both the importance and cost of social revolution--and how youth lead the way.', 23.0000, 999, 1, 3, N'CAT1')
INSERT [dbo].[Products] ([ProductID], [ProductName], [ImagePath], [CreatedDate], [Description], [UnitPrice], [UnitInStock], [IsContinue], [Ratting], [CategoryID]) VALUES (N'PD13', N'Little Fish', N'./public/image/9781551527208.jpg', CAST(N'2018-02-24' AS Date), N'In this extraordinary debut novel by the author of the Lambda Literary Award-winning story collection A Safe Girl to Love, Wendy Reimer is a thirty-year-old trans woman who comes across evidence that her late grandfather--a devout Mennonite farmer--might have been transgender himself. At first she dismisses this revelation, having other problems at hand, but as she and her friends struggle to cope with the challenges of their increasingly volatile lives--from alcoholism, to sex work, to suicide--Wendy is drawn to the lost pieces of her grandfathers life, becoming determined to unravel the mystery of his truth. Alternately warm-hearted and dark-spirited, desperate and mirthful, Little Fish explores the winter of discontent in the life of one transgender woman as her past and future become irrevocably entwined. ', 48.0000, 999, 1, 3, N'CAT3')
INSERT [dbo].[Products] ([ProductID], [ProductName], [ImagePath], [CreatedDate], [Description], [UnitPrice], [UnitInStock], [IsContinue], [Ratting], [CategoryID]) VALUES (N'PD2', N'The Thirty Names of Night', N'./public/image/9781982121525.webp', CAST(N'2017-12-23' AS Date), N'Five years after a suspicious fire killed his ornithologist mother, a closeted Syrian American trans boy sheds his birth name and searches for a new one. As his grandmothers sole caretaker, he spends his days cooped up in their apartment, avoiding his neighborhood masjid, his estranged sister, and even his best friend (who also happens to be his longtime crush). The only time he feels truly free is when he slips out at night to paint murals on buildings in the once-thriving Manhattan neighborhood known as Little Syria, but he''s been struggling ever since his mother''s ghost began visiting him each evening. ', 78.0000, 999, 1, 3, N'CAT3')
INSERT [dbo].[Products] ([ProductID], [ProductName], [ImagePath], [CreatedDate], [Description], [UnitPrice], [UnitInStock], [IsContinue], [Ratting], [CategoryID]) VALUES (N'PD3', N'Ciel', N'./public/image/9781772601367.webp', CAST(N'2012-02-12' AS Date), N'Ciel is excited to start high school. A gender non-conforming trans kid, Ciel has a YouTube channel and dreams of getting a better camera to really make their mark. Ciel can always rely on their best friend, Stephie, a trans girl who also happens to be a huge nerd. But their friendship begins to feel distant when Stephie makes it clear she wants the fact that she''s trans to be less visible now that they''re in high school. While navigating this new dynamic with Stephie, Ciel is also trying to make a long-distance relationship work with their boyfriend Eiríkur, who just moved back to Iceland. Add to the mix a cute swim star named Liam, and Ciel''s life is becoming more complicated by the minute! ', 40.0000, 999, 1, 3, N'CAT2')
INSERT [dbo].[Products] ([ProductID], [ProductName], [ImagePath], [CreatedDate], [Description], [UnitPrice], [UnitInStock], [IsContinue], [Ratting], [CategoryID]) VALUES (N'PD4', N'The Best of Assigned Male', N'./public/image/9781787755932.webp', CAST(N'2008-04-24' AS Date), N'Includes New and Never Before Seen Stories!

Follow young trans girl, Stephie, and her group of queer friends as they navigate school, family and relationships, and experiences of being trans.

Humorous and acerbic, this ground-breaking graphic narrative brilliantly explores the journey of discovering and embracing your evolving gender identity, and promotes a sense of community and empowerment through artfully illustrated stories.

Based on the hugely successful and influential webcomic Assigned Male, and in print for the first time, this expanded collection contains exclusive content as well as familiar, well-loved characters. ', 86.0000, 999, 1, 3, N'CAT3')
INSERT [dbo].[Products] ([ProductID], [ProductName], [ImagePath], [CreatedDate], [Description], [UnitPrice], [UnitInStock], [IsContinue], [Ratting], [CategoryID]) VALUES (N'PD5', N'Something That May Shock and Discredit You', N'./public/image/9781982105228.webp', CAST(N'2005-05-18' AS Date), N'Daniel M. Lavery is known for blending genres, forms, and sources to develop fascinating new hybrids--from lyric rants to horror recipes to pornographic scripture. In his most personal work to date, he turns his attention to the essay, offering vigorous and laugh-out-loud funny accounts of both popular and highbrow culture while mixing in meditations on gender transition, family dynamics, and the many meanings of faith. ', 82.0000, 999, 1, 3, N'CAT2')
INSERT [dbo].[Products] ([ProductID], [ProductName], [ImagePath], [CreatedDate], [Description], [UnitPrice], [UnitInStock], [IsContinue], [Ratting], [CategoryID]) VALUES (N'PD6', N'Confessions of the Fox', N'./public/image/9780399592287.jpg', CAST(N'2019-06-10' AS Date), N'Jack Sheppard and Edgeworth Bess were the most notorious thieves, jailbreakers, and lovers of eighteenth-century London. Yet no one knows the true story; their confessions have never been found. ', 52.0000, 999, 1, 3, N'CAT3')
INSERT [dbo].[Products] ([ProductID], [ProductName], [ImagePath], [CreatedDate], [Description], [UnitPrice], [UnitInStock], [IsContinue], [Ratting], [CategoryID]) VALUES (N'PD7', N'Fairest: A Memoir', N'./public/image/9780525561323.webp', CAST(N'2009-05-21' AS Date), N'Finalist for the 2021 Lambda Literary Award for Transgender Nonfiction

Talusan sails past the conventions of trans and immigrant memoirs. --The New York Times Book Review', 52.0000, 999, 1, 3, N'CAT5')
INSERT [dbo].[Products] ([ProductID], [ProductName], [ImagePath], [CreatedDate], [Description], [UnitPrice], [UnitInStock], [IsContinue], [Ratting], [CategoryID]) VALUES (N'PD8', N'An Unkindness of Ghosts', N'./public/image/9781617755880.jpg', CAST(N'2019-12-23' AS Date), N'What Solomon achieves with this debut--the sharpness, the depth, the precision--puts me in mind of a syringe full of stars. I want to say about this book, its only imperfection is that it ended. But that might give the wrong impression: that it is a happy book, a book that makes a body feel good. It is not a happy book. I love it like I love food, I love it for what it did to me, I love it for having made me feel stronger and more sure in a nightmare world, but it is not a happy book. It is an antidote to poison. It is inoculation against pervasive, enduring disease. Like a vaccine, it is briefly painful, leaves a lingering soreness, but armors you from the inside out.', 46.0000, 999, 1, 3, N'CAT4')
INSERT [dbo].[Products] ([ProductID], [ProductName], [ImagePath], [CreatedDate], [Description], [UnitPrice], [UnitInStock], [IsContinue], [Ratting], [CategoryID]) VALUES (N'PD9', N'Time Is the Thing a Body Moves Through', N'./public/image/9781566895477.jpg', CAST(N'1992-01-25' AS Date), N'How do the bodies we inhabit affect our relationship with art? How does art affect our relationship to our bodies? T Fleischmann uses Felix Gonzáles-Torress artworkspiles of candy, stacks of paper, puzzles--as a path through questions of love and loss, violence and rejuvenation, gender and sexuality. From the back porches of Buffalo, to the galleries of New York and L.A., to farmhouses of rural Tennessee, the artworks act as still points, sites for reflection situated in lived experience. Fleischmann combines serious engagement with warmth and clarity of prose, reveling in the experiences and pleasures of art and the body, identity and community. ', 81.0000, 999, 1, 3, N'CAT3')
GO
SET IDENTITY_INSERT [dbo].[Reports] ON 

INSERT [dbo].[Reports] ([ReportID], [Title], [CustomerName], [Email], [Phone], [Insurance], [Descriptions], [Status], [AccountID], [Time]) VALUES (1, N'thay oi em muon pass mon', N'Minh Vu', N'vudmhe140017@fpt.edu.vn', N'0818180399', N'6 months', N'Em dang co gang tung ngay de duoc pass mon', N'pending', N'Acc73192', CAST(N'2022-03-27' AS Date))
INSERT [dbo].[Reports] ([ReportID], [Title], [CustomerName], [Email], [Phone], [Insurance], [Descriptions], [Status], [AccountID], [Time]) VALUES (2, N'Co len', N'Minh Vu', N'vudmhe140017@fpt.edu.vn', N'0818180399', N'6 months', N'co len ban dung bao gio tu bo', N'pending', N'Acc73192', CAST(N'2022-03-27' AS Date))
INSERT [dbo].[Reports] ([ReportID], [Title], [CustomerName], [Email], [Phone], [Insurance], [Descriptions], [Status], [AccountID], [Time]) VALUES (3, N'Co len', N'Minh Vu', N'vudmhe140017@fpt.edu.vn', N'0818180399', N'6 months', N'co len ban dung bao gio tu bo', N'pending', N'Acc73192', CAST(N'2022-03-27' AS Date))
INSERT [dbo].[Reports] ([ReportID], [Title], [CustomerName], [Email], [Phone], [Insurance], [Descriptions], [Status], [AccountID], [Time]) VALUES (4, N'thay oi em muon pass mon', N'Minh Vu', N'vudmhe140017@fpt.edu.vn', N'0818180399', N'6 months', N'Em dang co gang tung ngay de duoc pass mon', N'pending', N'Acc73192', CAST(N'2022-03-27' AS Date))
SET IDENTITY_INSERT [dbo].[Reports] OFF
GO
SET IDENTITY_INSERT [dbo].[SalesPartner] ON 

INSERT [dbo].[SalesPartner] ([PartnerID], [PartnerName], [Address], [Product], [Email], [Phone], [Description], [Status]) VALUES (1, N'ABC Company', N'VN', N'Story about Conan', N'vudmhe140017@fpt.edu.vn', N'0818180399', N'we wanna sell all product about conan', N'Pending')
INSERT [dbo].[SalesPartner] ([PartnerID], [PartnerName], [Address], [Product], [Email], [Phone], [Description], [Status]) VALUES (3, N'Fujigo F5', N'Duy Tan Ha Noi', N'Story about Conan', N'vudmhe140017@fpt.edu.vn', N'0818180399', N'abc', N'Pending')
INSERT [dbo].[SalesPartner] ([PartnerID], [PartnerName], [Address], [Product], [Email], [Phone], [Description], [Status]) VALUES (4, N'ABC Company', N'Duy Tan', N'Story about Conan', N'vudmhe140017@fpt.edu.vn', N'0818180399', N'Hello my friend', N'Pending')
SET IDENTITY_INSERT [dbo].[SalesPartner] OFF
GO
ALTER TABLE [dbo].[Customer]  WITH CHECK ADD  CONSTRAINT [FK_Customer_Accounts] FOREIGN KEY([AccountID])
REFERENCES [dbo].[Accounts] ([AccountID])
GO
ALTER TABLE [dbo].[Customer] CHECK CONSTRAINT [FK_Customer_Accounts]
GO
ALTER TABLE [dbo].[Discount]  WITH CHECK ADD FOREIGN KEY([CustomerID])
REFERENCES [dbo].[Customer] ([CustomerID])
GO
ALTER TABLE [dbo].[Discount]  WITH CHECK ADD FOREIGN KEY([ProductID])
REFERENCES [dbo].[Products] ([ProductID])
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
ALTER DATABASE [BookShopsOnline] SET  READ_WRITE 
GO
