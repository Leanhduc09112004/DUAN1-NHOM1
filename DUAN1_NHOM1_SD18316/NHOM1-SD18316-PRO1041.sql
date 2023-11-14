USE MASTER
CREATE DATABASE PTPM_JAVA_FA23_PRO1041;
GO
USE PTPM_JAVA_FA23_PRO1041
GO
--NHAN VIEN--
CREATE TABLE NhanVien(
IdNV INT IDENTITY PRIMARY KEY,
MaNV nvarchar(50),
HoTen nvarchar(50),
GioiTinh nvarchar(10),
Sdt nvarchar(10),
NgaySinh date,
DiaChi nvarchar(50),
Email nvarchar(50),
ChucVu nvarchar(50),
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
IdSP INT
)
CREATE TABLE SanPham(
IdSP INT IDENTITY PRIMARY KEY,
MaSP nvarchar(50),
TenSP nvarchar(100),
TrangThai bit,
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
Soluong int,
IdNV INT ,
IdMau INT ,
IdHang INT,
IdSize INT,
IdKM INT,
)
--KHACH HANG--
CREATE TABLE KhachHang(
IdKH INT IDENTITY PRIMARY KEY,
MaKH nvarchar(50),
HoTen nvarchar(50),
Email nvarchar(50),
Sdt varchar(12),
GioiTinh nvarchar(10),
NgaySinh date,
DiaChi nvarchar(50),
TrangThai bit,
IdNV INT,
IdLoaiKhachHang INT
)
CREATE TABLE LoaiKhachHang(
IdLoaiKhachHang INT IDENTITY PRIMARY KEY,
MaLoaiKhachHang NVARCHAR(50),
TenLoaiKhachHang NVARCHAR(MAX)
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
IdSPCT INT,
IdHD INT,
SoLuong int,
DonGia float,
)
ALTER TABLE ChiTietSanPham
ADD CONSTRAINT FK_SanPhamCT_MauSac
FOREIGN KEY (IdMau) REFERENCES MauSac(IdMau);

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

ALTER TABLE KhachHang
ADD CONSTRAINT FK_KhachHang_NhanVien
FOREIGN KEY (IdNV) REFERENCES NhanVien(IdNV);

ALTER TABLE KhachHang
ADD CONSTRAINT FK_KhachHang_LoaiKhachHang
FOREIGN KEY (IdLoaiKhachHang) REFERENCES LoaiKhachHang(IdLoaiKhachHang);

ALTER TABLE HoaDon
ADD CONSTRAINT FK_HoaDon_KhachHang
FOREIGN KEY (IdKH) REFERENCES KhachHang(IdKH);

ALTER TABLE HoaDonChiTiet
ADD CONSTRAINT FK_SanPham_HoaDonCT
FOREIGN KEY (IdSPCT) REFERENCES ChiTietSanPham(IdCTSP);

ALTER TABLE ChiTietSanPham
ADD CONSTRAINT FK_SanPham_NhanVien
FOREIGN KEY (IdNV) REFERENCES NhanVien(IdNV);

ALTER TABLE ChiTietSanPham
ADD CONSTRAINT FK_SanPham_LoaiSanPham
FOREIGN KEY (IdLoaiSanPham) REFERENCES LoaiSanPham(IdLoaiSanPham);

ALTER TABLE ChiTietSanPham
ADD CONSTRAINT FK_CTSanPham_SanPham
FOREIGN KEY (IdSP) REFERENCES SanPham(IdSP);

 USE PTPM_JAVA_FA23_PRO1041

 INSERT INTO NhanVien (MaNV, HoTen, GioiTinh, Sdt, NgaySinh, DiaChi, Email, ChucVu, TrangThai, MatKhau)
VALUES ('NV001', N'Lê Đức Anh', N'Nam', '0123456789', '2000-01-01', N'Hà Nội', N'nv1@example.com', N'Quản lý', 1, '123456'),
       ('NV002', N'Nguyễn Thị Thu Quyên', N'Nữ', '0987654321', '2001-02-02', N'Hà Nội', 'nv2@example.com', N'Quản lý', 1, '123456'),
       ('NV003', N'Đằng Trần Giang Sơn', N'Nam', '0369852147', '1999-03-03', N'Tuyên Quang', 'nv3@example.com', N'Nhân viên', 1, '123456'),
       ('NV004', N'Nguyễn Thị Vân', N'Nữ', '0358746921', '1998-04-04', N'Hà Nội', 'nv4@example.com', N'Nhân viên', 1, '123456'),
       ('NV005', N'Cao Bá Trường', N'Nam', '0936284715', '1997-05-05', N'Tuyên Quang', 'nv5@example.com', N'Quản lý', 1, '123456');
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

INSERT INTO SanPham (MaSP, TenSP, TrangThai)
VALUES ('SP001', N'Adidas Ultraboost', 1),
       ('SP002', N'Converse Chucktaylo 1970', 1),
       ('SP003', 'Adidas Forum', 1),
       ('SP004', 'Nike AirForce 1', 1),
       ('SP005', 'Nike ReactFly', 1);
SELECT*FROM SanPham

INSERT INTO KhuyenMai (MaKM, TenKM, NgayBatDau, NgayKetThuc, DieuKien, TienGiam, TrangThai, IdSP)
VALUES ('KM001', N'Khuyến mãi 1', '2023-01-01', '2023-01-10', N'Áp dụng cho đơn hàng trên 1 triệu đồng', 150000, 1, 1),
       ('KM002', N'Khuyến mãi 2', '2023-02-01', '2023-02-28', N'Áp dụng cho tất cả đơn hàng', 50000, 1, 2),
       ('KM003', N'Khuyến mãi 3', '2023-03-01', '2023-03-15', N'Áp dụng cho đơn hàng trên 500 nghìn đồng', 60000, 1, 3),
       ('KM004', N'Khuyến mãi 4', '2023-04-01', '2023-04-30', N'Áp dụng cho đơn hàng trên 2 triệu đồng', 250000, 1, 4),
       ('KM005', N'Khuyến mãi 5', '2023-05-01', '2023-05-31', N'Áp dụng cho đơn hàng trên 5 triệu đồng', 300000, 1, 5);
SELECT * FROM KhuyenMai A JOIN SanPham B ON A.IdSP= B.IdSP JOIN ChiTietSanPham C ON B.IdSP= C.IdSP

INSERT INTO ChiTietSanPham (IdSP, IdLoaiSanPham, GiaBan, GiaNhap, HinhAnh, Mota, Soluong, IdNV, IdMau, IdHang, IdSize, IdKM)
VALUES (1, 1, 2000000, 1500000, 'adidasultra.jpg', N'Giày chạy bộ Adidas', 10, 1, 1, 1, 1, 1),
       (2, 2, 3000000, 2500000, 'converse.jpg', N'Giày thời trang Converse', 15, 1, 2, 2, 2, 2),
       (3, 2, 1500000, 1000000, 'adidasforum.jpg', N'Giày thời trang Adidas', 8, 1, 3, 3, 3, 3),
       (4, 2, 3000000, 2000000, 'nikeair.jpg', N'Giày thời trang Nike', 20, 2, 4, 4, 4, 4),
       (5, 1, 3500000, 3000000, 'nikereact.jpg', N'Giày chạy bộ Nike', 15, 2, 5, 5, 5, 5);

  INSERT INTO LoaiKhachHang (MaLoaiKhachHang, TenLoaiKhachHang)
VALUES ('LKH001', N'Khách lẻ'),
       ('LKH002', N'Khách doanh nghiệp')

INSERT INTO KhachHang (MaKH, HoTen, Email, Sdt, GioiTinh, NgaySinh, DiaChi, TrangThai, IdNV, IdLoaiKhachHang)
VALUES ('KH001', N'Nguyễn Văn An', 'nva@example.com', '0123456789', N'Nam', '1995-01-01', N'Hà Nội', 1, 1, 1),
       ('KH002', N'Trần Thị Bình', 'ttb@example.com', '0987654321', N'Nữ', '1996-02-02', N'Hải Phòng', 1, 2, 2),
       ('KH003', N'Phan Văn Khánh', 'pvk@example.com', '0369852147', N'Nam', '1997-03-03', N'Đà Nẵng', 1, 3, 2),
       ('KH004', N'Hoàng Thị Lan', 'htl4@example.com', '0358746921', N'Nữ', '1998-04-04', N'Cần Thơ', 1, 4, 1),
       ('KH005', N'Lê Văn Nam', 'lvn@example.com', '0936284715', N'Nam', '1999-05-05', N'Quảng Ninh', 1, 5, 1);

	   SELECT * FROM KhachHang A Join LoaiKhachHang B ON A.IdLoaiKhachHang=B.IdLoaiKhachHang
INSERT INTO HoaDon (MaHD, NgayTao, NgayThanhToan, TongTien, TienGiam, TienDua, TienThua, TrangThai, IdNV, GhiChu, IdKH)
VALUES ('HD001', '2023-01-01', '2023-01-03', 2000000, 150000, 2000000,1850000, 1, 1, '', 1),
       ('HD002', '2023-02-01', '2023-02-02', 3000000, 50000, 3000000, 2950000, 1, 1, '', 2),
       ('HD003', '2023-03-01', '2023-03-15', 1500000, 60000, 1500000, 1440000, 1, 2, '', 3),
       ('HD004', '2023-04-01', '2023-04-03', 6000000, 250000, 6000000, 5750000, 1, 2, '', 4);
INSERT INTO HoaDonChiTiet (IdSPCT, IdHD, SoLuong, DonGia)
VALUES 
    (1, 1, 1, 2000000),
    (2, 2, 1, 3000000),
    (3, 3, 1, 1500000), 
    (4, 4, 2, 6000000); 





