USE MASTER
CREATE DATABASE DA1;
GO
USE DA1
GO
--NHAN VIEN--
CREATE TABLE NhanVien(
IdNV INT IDENTITY PRIMARY KEY,
MaNV nvarchar(50),
HoTen nvarchar(50),
GioiTinh bit,
Sdt nvarchar(10),
NgaySinh date,
DiaChi nvarchar(50),
Email nvarchar(50),
ChucVu bit,
TrangThai bit,
MatKhau nvarchar(50)
)
--MAU SAC--
CREATE TABLE MauSac(
IdMau INT IDENTITY PRIMARY KEY,
MaMau nvarchar(50),
TenMau nvarchar(100)
)
GO
--THUONG HIEU--
CREATE TABLE HangSanXuat(
IdHang INT IDENTITY PRIMARY KEY,
MaHangSanXuat nvarchar(50),
TenHangSanXuat nvarchar(100)
)
GO
CREATE TABLE SizeSP(
IdSize INT IDENTITY PRIMARY KEY,
MaSize nvarchar(50),
Size nvarchar(100)
)
CREATE TABLE LoaiSanPham(
IdLoaiSanPham INT IDENTITY PRIMARY KEY,
MaLoaiSanPham nvarchar(50),
TenLoaiSanPham nvarchar(100)
)
CREATE TABLE KhuyenMai(
IdKM INT IDENTITY PRIMARY KEY,
MaKM nvarchar(50),
TenKM nvarchar(100),
NgayBatDau date,
NgayKetThuc date,
DieuKien nvarchar(max),
TienGiam float,
TrangThai bit,
IdSP INT,
IdLoaiSP INT
)
CREATE TABLE SanPham(
IdSP INT IDENTITY PRIMARY KEY,
MaSP nvarchar(50),
TenSP nvarchar(100),
)
--SAN PHAM--
CREATE TABLE ChiTietSanPham(
IdCTSP INT IDENTITY PRIMARY KEY,
IdSP INT,
IdLoaiSanPham INT,
GiaBan float,
GiaNhap float,
HinhAnh nvarchar(max),
Mota nvarchar(50),
Soluong INT,
IdMau INT ,
IdHang INT,
IdSize INT,
IdKM INT,
TrangThai bit
)
--KHACH HANG--
CREATE TABLE KhachHang(
IdKH INT IDENTITY PRIMARY KEY,
MaKH nvarchar(50),
HoTen nvarchar(50),
Email nvarchar(50),
Sdt varchar(12),
GioiTinh bit,
NgaySinh date,
DiaChi nvarchar(50),
)
--HOA DON--
CREATE TABLE HoaDon(
IdHD INT IDENTITY PRIMARY KEY,
MaHD nvarchar(50),
NgayTao date,
NgayThanhToan date,
TongTien float,
TienGiam float,
TienDua float,
TienThua float,
TrangThai bit,
IdNV INT,
GhiChu nvarchar(50),
IdKH INT
)
GO
--HOA DON CHI TIET--
CREATE TABLE HoaDonChiTiet(
IdHDCT INT IDENTITY PRIMARY KEY,
IdCTSP INT,
IdHD INT,
SoLuong int,
DonGia float,
)
ALTER TABLE ChiTietSanPham
ADD CONSTRAINT FK_SanPhamCT_MauSac
FOREIGN KEY (IdMau) REFERENCES MauSac(IdMau);

ALTER TABLE KhuyenMai
ADD CONSTRAINT FK_SanPhamKhuyenMai
FOREIGN KEY (IdSP) REFERENCES SanPham(IdSP);

ALTER TABLE KhuyenMai
ADD CONSTRAINT FK_SanPham_LoaiSP
FOREIGN KEY (IdLoaiSP) REFERENCES LoaiSanPham(IdLoaiSanPham);

ALTER TABLE ChiTietSanPham
ADD CONSTRAINT FK_SanPhamCT_HangSanXuat
FOREIGN KEY (IdHang) REFERENCES HangSanXuat(IdHang);

ALTER TABLE ChiTietSanPham
ADD CONSTRAINT FK_SanPhamCT_SizeSP
FOREIGN KEY (IdSize) REFERENCES SizeSP(IdSize);

ALTER TABLE ChiTietSanPham
ADD CONSTRAINT FK_SanPhamCT_KhuyenMai
FOREIGN KEY (IdKM) REFERENCES KhuyenMai(IdKM);

ALTER TABLE HoaDon
ADD CONSTRAINT FK_HoaDon_NhanVien
FOREIGN KEY (IdNV) REFERENCES NhanVien(IdNV);

ALTER TABLE HoaDonChiTiet
ADD CONSTRAINT FK_HoaDon_HoaDonCT
FOREIGN KEY (IdHD) REFERENCES HoaDon(IdHD);

ALTER TABLE HoaDon
ADD CONSTRAINT FK_HoaDon_KhachHang
FOREIGN KEY (IdKH) REFERENCES KhachHang(IdKH);

ALTER TABLE HoaDonChiTiet
ADD CONSTRAINT FK_SanPham_HoaDonCT
FOREIGN KEY (IdCTSP) REFERENCES ChiTietSanPham(IdCTSP);

ALTER TABLE ChiTietSanPham
ADD CONSTRAINT FK_SanPham_LoaiSanPham
FOREIGN KEY (IdLoaiSanPham) REFERENCES LoaiSanPham(IdLoaiSanPham);

ALTER TABLE ChiTietSanPham
ADD CONSTRAINT FK_CTSanPham_SanPham
FOREIGN KEY (IdSP) REFERENCES SanPham(IdSP);

 INSERT INTO NhanVien (MaNV, HoTen, GioiTinh, Sdt, NgaySinh, DiaChi, Email, ChucVu, TrangThai, MatKhau)
VALUES ('NV001', N'Lê Đức Anh', 1, '0123456789', '2000-01-01', N'Hà Nội', N'nv1@example.com', 1, 1, '123456'),
			 ('NV002', N'Nguyễn Thị Thu Quyên', 0, '0987654321', '2001-02-02', N'Hà Nội', 'nv2@example.com', 1, 1, '123456'),
       ('NV003', N'Đằng Trần Giang Sơn', 1, '0369852147', '1999-03-03', N'Tuyên Quang', 'nv3@example.com', 1, 1, '123456'),
       ('NV004', N'Nguyễn Thị Vân', 0, '0358746921', '1998-04-04', N'Hà Nội', 'nv4@example.com', 0, 1, '123456'),
       ('NV005', N'Cao Bá Trường', 1, '0936284715', '1997-05-05', N'Tuyên Quang', 'nv5@example.com',1, 1, '123456'),
	   ('NV006', N'Phạm Văn An', 1, '086284715', '1999-05-05', N'Nam Định', 'nv6@example.com', 0, 0, '123'),
	   ('NV007', N'Lê Bảo Ngân', 0, '0999984715', '2000-02-11', N'Hải Phòng', 'nv7@example.com', 1, 0, '123'),
	   ('NV008', N'Nguyễn Như Quỳnh', 0, '082224715', '1999-05-05', N'TP HCM', 'nv8@example.com', 0, 0, '123');

SELECT *FROM NhanVien

INSERT INTO MauSac (MaMau, TenMau)
VALUES ('MS001', N'Xanh'),
             ('MS002', N'Đỏ'),
             ('MS003', N'Vàng'),
             ('MS004', N'Trắng'),
             ('MS005', N'Đen'),
	         ('MS006', N'Xang Lá Cây'),
		     ('MS007', N'Xám'),
		     ('MS008', N'Nâu')
SELECT *FROM MauSac

INSERT INTO HangSanXuat (MaHangSanXuat, TenHangSanXuat)
VALUES ('HSX001', N'Nike'),
       ('HSX002', N'Adidas'),
       ('HSX003', N'Puma'),
       ('HSX004', N'Converse'),
       ('HSX005', N'New Balance');
SELECT * FROM HangSanXuat

INSERT INTO SizeSP (MaSize, Size)
VALUES ('SZ001', '36'),
       ('SZ002', '37'),
       ('SZ003', '38'),
       ('SZ004', '39'),
       ('SZ005', '40'),
	   ('SZ006', '41'),
	   ('SZ007', '42'),
	   ('SZ008', '43'),
       ('SZ009', '44');
SELECT* FROM SizeSP

INSERT INTO LoaiSanPham (MaLoaiSanPham, TenLoaiSanPham)
VALUES ('LSP001', N'Giày chạy bộ'),
       ('LSP002', N'Giày thời trang'),
       ('LSP003', N'Giày bóng rổ'),
       ('LSP004', N'Giày bóng đá')
SELECT * FROM LoaiSanPham

INSERT INTO SanPham (MaSP, TenSP)
VALUES ('SP001', N'Adidas Ultraboost'),
       ('SP002', N'Converse Chucktaylo 1970'),
       ('SP003', 'Adidas Forum'),
       ('SP004', 'Nike AirForce 1'),
       ('SP005', 'Nike ReactFly');
SELECT*FROM SanPham

INSERT INTO KhuyenMai (MaKM, TenKM, NgayBatDau, NgayKetThuc, DieuKien, TienGiam, TrangThai, IdSP, IdLoaiSP)
VALUES ('KM001', N'Khuyến mãi 1', '2023-10-10', '2023-12-12', N'Áp dụng cho đơn hàng trên 1 triệu đồng', 150000, 1, 1,1),
       ('KM002', N'Khuyến mãi 2', '2023-09-01', '2023-12-29', N'Áp dụng cho tất cả đơn hàng', 50000, 1, 2,2),
       ('KM003', N'Khuyến mãi 3', '2023-08-01', '2023-12-28', N'Áp dụng cho đơn hàng trên 500 nghìn đồng', 60000, 1, 3, 3),
       ('KM004', N'Khuyến mãi 4', '2023-07-01', '2024-01-30', N'Áp dụng cho đơn hàng trên 2 triệu đồng', 250000, 1, 4, 4),
       ('KM005', N'Khuyến mãi 5', '2023-05-01', '2024-01-01', N'Áp dụng cho đơn hàng trên 5 triệu đồng', 300000, 1, 5,3),
	   ('KM006', N'Khuyến mãi 6', '2023-06-01', '2023-10-10', N'Áp dụng cho đơn hàng trên 1 triệu đồng', 300000, 0, 1,1),
	   ('KM007', N'Khuyến mãi 7', '2023-07-01', '2023-09-12', N'Áp dụng cho đơn hàng trên 2 triệu đồng', 300000, 0, 5,2);

	   SELECT *FROM KhuyenMai

INSERT INTO ChiTietSanPham (IdSP, IdLoaiSanPham, GiaBan, GiaNhap, HinhAnh, Mota, Soluong,IdMau, IdHang, IdSize, IdKM, TrangThai)
VALUES (1, 1, 2000000, 1500000, 'adidasultra.jpg', N'Giày chạy bộ Adidas', 10, 1, 1, 1, 1,1),
               (2, 2, 3000000, 2500000, 'converse.jpg', N'Giày thời trang Converse', 15, 2, 2, 2, 2,1),
               (3, 2, 1500000, 1000000, 'adidasforum.jpg', N'Giày thời trang Adidas', 8, 3, 3, 3, 3,1),
               (4, 2, 3000000, 2000000, 'nikeair.jpg', N'Giày thời trang Nike', 20, 4, 4, 4, 4,1),
             (5, 1, 3500000, 3000000, 'nikereact.jpg', N'Giày chạy bộ Nike', 15, 5, 5, 5, 5,1);

SELECT *FROM ChiTietSanPham

INSERT INTO KhachHang (MaKH, HoTen, Email, Sdt, GioiTinh, NgaySinh, DiaChi)
VALUES ('KH001', N'Nguyễn Văn An', 'nva@example.com', '0123456789', 1, '1995-01-01', N'Hà Nội'),
       ('KH002', N'Trần Thị Bình', 'ttb@example.com', '0987654321',0, '1996-02-02', N'Hải Phòng'),
       ('KH003', N'Phan Văn Khánh', 'pvk@example.com', '0369852147', 1, '1997-03-03', N'Đà Nẵng'),
       ('KH004', N'Hoàng Thị Lan', 'htl4@example.com', '0358746921', 0, '1998-04-04', N'Cần Thơ'),
       ('KH005', N'Lê Văn Nam', 'lvn@example.com', '0936284715', 1, '1999-05-05', N'Quảng Ninh');

	   SELECT * FROM KhachHang 
INSERT INTO HoaDon (MaHD, NgayTao, NgayThanhToan, TongTien, TienGiam, TienDua, TienThua, TrangThai, IdNV, GhiChu, IdKH)
VALUES ('HD001', '2023-01-01', '2023-01-03', 2000000, 150000, 2000000,1850000, 1, 1, '', 1),
       ('HD002', '2023-02-01', '2023-02-02', 3000000, 50000, 3000000, 2950000, 1, 1, '', 2),
       ('HD003', '2023-03-01', '2023-03-15', 1500000, 60000, 1500000, 1440000, 1, 2, '', 3),
       ('HD004', '2023-04-01', '2023-04-03', 6000000, 250000, 6000000, 5750000, 1, 2, '', 4);

INSERT INTO HoaDonChiTiet (IdCTSP, IdHD, SoLuong, DonGia)
VALUES 
    (1, 1, 1, 2000000),
    (2, 2, 1, 3000000),
    (3, 3, 1, 1500000), 
    (4, 4, 2, 6000000); 


