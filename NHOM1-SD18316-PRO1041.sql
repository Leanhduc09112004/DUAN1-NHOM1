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
--HANG SAN XUAT-
CREATE TABLE HangSanXuat(
IdHang INT IDENTITY PRIMARY KEY,
MaHangSanXuat nvarchar(50),
TenHangSanXuat nvarchar(100)
)
GO
--SIZESP
CREATE TABLE SizeSP(
IdSize INT IDENTITY PRIMARY KEY,
MaSize nvarchar(50),
Size nvarchar(100)
)
--LOAI SAN PHAM
CREATE TABLE LoaiSanPham(
IdLoaiSanPham INT IDENTITY PRIMARY KEY,
MaLoaiSanPham nvarchar(50),
TenLoaiSanPham nvarchar(100)
)
--SAN PHAM
CREATE TABLE SanPham(
IdSP INT IDENTITY PRIMARY KEY,
MaSP nvarchar(50),
TenSP nvarchar(100),
IdLoaiSanPham INT,
GiaBan MONEY,
GiaNhap MONEY,
HinhAnh nvarchar(max),
Mota nvarchar(50),
Soluong INT,
IdMau INT ,
IdHang INT,
IdSize INT,
TrangThai bit
)
--GIO HANG
CREATE TABLE GioHang(
IdGioHang INT IDENTITY PRIMARY KEY,
MaGioHang nvarchar(50),
IdNV INT,
)
--GIO HANG CHI TIET
CREATE TABLE GioHangChiTiet(
IdGioHangChiTiet INT IDENTITY PRIMARY KEY,
MaGioHangChiTiet nvarchar(50),
IdGioHang INT,
IdSP INT,
SoLuong INT,
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
--KHUYEN MAI
CREATE TABLE KhuyenMai(
IdKM INT IDENTITY PRIMARY KEY,
MaKM nvarchar(50),
TenKM nvarchar(100),
NgayBatDau DATE,
NgayKetThuc DATE,
DieuKien nvarchar(max),
GhiChu nvarchar(50),
TienGiam FLOAT,
TrangThai bit
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
IdKM INT,
GhiChu nvarchar(50),
IdKH INT
)
GO
--HOA DON CHI TIET--
CREATE TABLE HoaDonChiTiet(
IdHDCT INT IDENTITY PRIMARY KEY,
IdSP INT,
IdHD INT,
SoLuong int,
DonGia float,
)
ALTER TABLE SanPham
ADD CONSTRAINT FK_SanPhamCT_MauSac
FOREIGN KEY (IdMau) REFERENCES MauSac(IdMau);

ALTER TABLE SanPham
ADD CONSTRAINT FK_SanPhamCT_HangSanXuat
FOREIGN KEY (IdHang) REFERENCES HangSanXuat(IdHang);

ALTER TABLE SanPham
ADD CONSTRAINT FK_SanPhamCT_SizeSP
FOREIGN KEY (IdSize) REFERENCES SizeSP(IdSize);

ALTER TABLE SanPham
ADD CONSTRAINT FK_SanPham_LoaiSanPham
FOREIGN KEY (IdLoaiSanPham) REFERENCES LoaiSanPham(IdLoaiSanPham);

ALTER TABLE GioHang
ADD CONSTRAINT FK_GioHang_NhanVien
FOREIGN KEY (IdNV) REFERENCES NhanVien(IdNV);

ALTER TABLE GioHangChiTiet
ADD CONSTRAINT FK_GioHangChiTiet_GioHang
FOREIGN KEY (IdGioHang) REFERENCES GioHang(IdGioHang);

ALTER TABLE GioHangChiTiet
ADD CONSTRAINT FK_GioHangChiTiet_SanPham
FOREIGN KEY (IdSP) REFERENCES SanPham(IdSP);

ALTER TABLE HoaDon
ADD CONSTRAINT FK_HoaDon_NhanVien
FOREIGN KEY (IdNV) REFERENCES NhanVien(IdNV);

ALTER TABLE HoaDon
ADD CONSTRAINT FK_HoaDon_KhuyenMai
FOREIGN KEY (IdKM) REFERENCES KhuyenMai(IdKM);

ALTER TABLE HoaDon
ADD CONSTRAINT FK_HoaDon_KhachHang
FOREIGN KEY (IdKH) REFERENCES KhachHang(IdKH);

ALTER TABLE HoaDonChiTiet
ADD CONSTRAINT FK_HoaDonChiTiet_SanPham
FOREIGN KEY (IdSP) REFERENCES SanPham(IdSP);

ALTER TABLE HoaDonChiTiet
ADD CONSTRAINT FK_HoaDonChiTiet_HoaDon
FOREIGN KEY (IdHD) REFERENCES HoaDon(IdHD);

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

INSERT INTO KhachHang (MaKH, HoTen, Email, Sdt, GioiTinh, NgaySinh, DiaChi)
VALUES ('KH001', N'Nguyễn Văn An', 'nva@example.com', '0123456789', 1, '1995-01-01', N'Hà Nội'),
       ('KH002', N'Trần Thị Bình', 'ttb@example.com', '0987654321',0, '1996-02-02', N'Hải Phòng'),
       ('KH003', N'Phan Văn Khánh', 'pvk@example.com', '0369852147', 1, '1997-03-03', N'Đà Nẵng'),
       ('KH004', N'Hoàng Thị Lan', 'htl4@example.com', '0358746921', 0, '1998-04-04', N'Cần Thơ'),
       ('KH005', N'Lê Văn Nam', 'lvn@example.com', '0936284715', 1, '1999-05-05', N'Quảng Ninh'),
	   ('KH006', N'Phan Thị Ngọc Hạnh', 'ptnh@example.com', '0987654321', 0, '1996-06-06', N'Hà Nội'),
('KH007', N'Trần Văn An', 'tva@example.com', '0369852147', 1, '1997-07-07', N'Hải Phòng'),
('KH008', N'Nguyễn Thị Mai', 'ntm@example.com', '0358746921', 0, '1998-08-08', N'Đà Nẵng'),
('KH009', N'Lê Văn Hùng', 'lvh@example.com', '0936284715', 1, '1999-09-09', N'Cần Thơ'),
('KH010', N'Hoàng Thị Lệ', 'htl@example.com', '0928374651', 0, '2000-10-10', N'Hồ Chí Minh'),
('KH011', N'Trần Đình Nam', 'tdn@example.com', '0987654321', 1, '1995-05-05', N'Hà Nam'),
('KH012', N'Nguyễn Thị Quỳnh', 'ntq@example.com', '0369852147', 0, '1996-06-06', N'Hải Dương'),
('KH013', N'Lê Văn Tùng', 'lvt@example.com', '0358746921', 1, '1997-07-07', N'Nam Định'),
('KH014', N'Phạm Thị Linh', 'ptl@example.com', '0936284715', 0, '1998-08-08', N'Thái Bình'),
('KH015', N'Vũ Văn Lực', 'vvl@example.com', '0928374651', 1, '1999-09-09', N'Hà Nội'),
('KH016', N'Nguyễn Thị Hương', 'nth@example.com', '0987654321', 0, '2000-10-10', N'Hải Phòng'),
('KH017', N'Đỗ Văn Tú', 'dvt@example.com', '0369852147', 1, '1995-05-05', N'Hà Nam'),
('KH018', N'Phạm Thị Mai', 'ptm@example.com', '0358746921', 0, '1996-06-06', N'Hải Dương'),
('KH019', N'Lê Văn Hòa', 'lvh@example.com', '0936284715', 1, '1997-07-07', N'Nam Định'),
('KH020', N'Trần Thị Quỳnh', 'ttq@example.com', '0928374651', 0, '1998-08-08', N'Thái Bình'),
('KH021', N'Hoàng Văn Dũng', 'hvd@example.com', '0987654321', 1, '1999-09-09', N'Hà Nội'),
('KH022', N'Nguyễn Thị Hà', 'nth@example.com', '0369852147', 0, '2000-10-10', N'Hải Phòng'),
('KH023', N'Lê Văn Hoàng', 'lvh@example.com', '0358746921', 1, '1995-05-05', N'Hà Nam'),
('KH024', N'Trần Thị Mai', 'ttm@example.com', '0936284715', 0, '1996-06-06', N'Hải Dương'),
('KH025', N'Vũ Văn Long', 'vvl@example.com', '0369852147', 1, '1995-05-05', N'Hải Dương'),
('KH026', N'Phạm Thị Thủy', 'ptt@example.com', '0358746921', 0, '1996-06-06', N'Hà Nam'),
('KH027', N'Nguyễn Văn Nam', 'nvn@example.com', '0936284715', 1, '1997-07-07', N'Hải Phòng'),
('KH028', N'Lê Thị Lan', 'ltl@example.com', '0928374651', 0, '1998-08-08', N'Nam Định'),
('KH029', N'Trần Văn Trường', 'tvt@example.com', '0987654321', 1, '1999-09-09', N'Hà Nội'),
('KH030', N'Đỗ Thị Thảo', 'dtt@example.com', '0928374651', 0, '2000-10-10', N'Hải Phòng');
SELECT * FROM KhachHang

INSERT INTO SanPham (MaSP, TenSP, IdLoaiSanPham, GiaBan, GiaNhap, HinhAnh, Mota, Soluong, IdMau, IdHang, IdSize, TrangThai)
VALUES ('SP001', N'Giày Adidas UltraBoost', 1, 2000000, 1500000, 'adidasultra.jpg', N'Giày chạy bộ Adidas', 10, 1, 1, 1,1),
               ('SP002', N'Giày Converse ChuckTayLor 1970', 2, 3000000, 2500000, 'converse.jpg', N'Giày thời trang Converse', 15, 2, 2, 2,1),
               ('SP003', N'Giày Adidas Forum', 2, 1500000, 1000000, 'adidasforum.jpg', N'Giày thời trang Adidas', 8, 3, 3, 3,1),
               ('SP004', N'Giày Nike React', 1, 3000000, 2000000, 'nikeair.jpg', N'Giày thời trang Nike', 20, 4, 4, 4,1),
             ('SP005', N'Giày Nike Zoom', 1, 3500000, 3000000, 'nikereact.jpg', N'Giày chạy bộ Nike', 15, 5, 5, 5,1);

SELECT A.MaSP, A.TenSP, B.TenLoaiSanPham, A.GiaBan, A.GiaNhap, A.HinhAnh, A.Mota, A.Soluong,C.TenMau,D.TenHangSanXuat,E.Size,A.TrangThai FROM 
SanPham A JOIN LoaiSanPham B ON A.IdLoaiSanPham=B.IdLoaiSanPham JOIN MauSac C ON A.IdMau=C.IdMau 
JOIN HangSanXuat D ON A.IdHang=D.IdHang JOIN SizeSP E ON A.IdSize=E.IdSize

INSERT INTO GioHang (MaGioHang, IdNV)
VALUES ('GH001', 1),
       ('GH002', 2),
       ('GH003', 3),
       ('GH004', 4),
       ('GH005', 5);

SELECT * FROM GioHang;

-- Insert into GioHangChiTiet
INSERT INTO GioHangChiTiet (MaGioHangChiTiet, IdGioHang, IdSP, SoLuong)
VALUES ('GHCT001', 1, 1, 2),
       ('GHCT002', 1, 2, 1),
       ('GHCT003', 2, 3, 3),
       ('GHCT004', 3, 4, 1),
       ('GHCT005', 4, 5, 2);

SELECT * FROM GioHangChiTiet;

-- Insert into KhuyenMai
INSERT INTO KhuyenMai (MaKM, TenKM, NgayBatDau, NgayKetThuc, DieuKien, GhiChu, TienGiam, TrangThai)
VALUES ('KM001', N'Khuyến mãi hóa đơn 1tr', '2023-11-26', '2023-12-26', N'Giảm 70 nghìn cho hóa đơn trên 1 triệu', N'', 70000, 1),
       ('KM002', N'Khuyến mãi hóa đơn 2tr', '2023-11-26', '2023-12-26', N'Giảm 150 nghìn cho đơn hàng trên 2 triệu', N'', 150000, 1),
       ('KM003', N'Khuyến mãi mau hàng lần đầu', '2023-11-26', '2023-12-26', N'Giảm 50 nghìn cho hóa đơn mua hàng lần đầu', N'', 50000, 1),
       ('KM004', N'Khuyến mãi hóa đơn 3tr', '2023-11-26', '2023-12-26', N'Giảm 200000 cho đơn hàng trên 3 triệu', N'', 200000, 1);

SELECT * FROM KhuyenMai;

-- Insert into HoaDon
INSERT INTO HoaDon (MaHD, NgayTao, NgayThanhToan, TongTien, TienGiam, TienDua, TienThua, TrangThai, IdNV, IdKM, GhiChu, IdKH)
VALUES			('HD001', '2023-11-26', '2023-11-27', 7000000, 70000, 7000000, 70000, 1, 1, 1, N'Đơn hàng số 1', 1 ),
				('HD002', '2023-11-27', '2023-11-28', 4500000, 150000, 4350000, 0, 1, 2, 2, N'Đơn hàng số 2', 2),
				('HD003', '2023-11-28', '2023-11-29', 3000000, 50000, 3000000, 50000, 2, 3, 3, N'Đơn hàng số 3', 3),
				('HD004', '2023-11-29', '2023-11-30', 3500000, 200000, 3300000, 0, 2, 4, 1, N'Đơn hàng số 4', 4),
				('HD005', '2022-12-01', '2022-12-02', 4000000, 100000, 3900000, 0, 1, 5, 1, N'Đơn hàng số 5', 6),
('HD006', '2022-12-02', '2022-12-03', 5500000, 150000, 5350000, 0, 1, 4, 2, N'Đơn hàng số 6', 7),
('HD007', '2022-12-03', '2022-12-04', 6500000, 200000, 6300000, 0, 2, 3, 3, N'Đơn hàng số 7', 8),
('HD008', '2022-12-04', '2022-12-05', 3000000, 50000, 3000000, 50000, 2, 2, 4, N'Đơn hàng số 8', 9),
('HD009', '2022-12-05', '2022-12-06', 4500000, 90000, 4410000, 0, 3, 1, 1, N'Đơn hàng số 9', 10),
('HD010', '2022-12-06', '2022-12-07', 5000000, 100000, 4900000, 0, 1, 2, 2, N'Đơn hàng số 10', 11),
('HD011', '2022-12-07', '2022-12-08', 6000000, 120000, 5880000, 0, 2, 4, 2, N'Đơn hàng số 11', 12),
('HD012', '2022-12-08', '2022-12-09', 4500000, 90000, 4410000, 0, 3, 3, 3, N'Đơn hàng số 12', 13),
('HD013', '2022-12-09', '2022-12-10', 3000000, 50000, 3000000, 50000, 1, 5, 4, N'Đơn hàng số 13', 14),
('HD014', '2022-12-10', '2022-12-11', 3500000, 200000, 3300000, 0, 2, 4, 1, N'Đơn hàng số 14', 15),
('HD015', '2022-12-11', '2022-12-12', 7000000, 70000, 7000000, 70000, 1, 1, 1, N'Đơn hàng số 15', 16),
('HD016', '2022-12-12', '2022-12-13', 4500000, 90000, 4410000, 0, 3, 2, 2, N'Đơn hàng số 16', 17),
('HD017', '2022-12-13', '2022-12-14', 3000000, 50000, 3000000, 50000, 2, 3, 3, N'Đơn hàng số 17', 18),
('HD018', '2022-12-14', '2022-12-15', 3500000, 200000, 3300000, 0, 1, 1, 1, N'Đơn hàng số 18', 19),
('HD019', '2022-12-15', '2022-12-16', 6000000, 120000, 5880000, 0, 2, 4, 2, N'Đơn hàng số 19', 20),
('HD021', '2023-12-16', '2023-12-17', 4000000, 200000, 3800000, 0, 8, 4, 1, N'Đơn hàng số 21', 1),
('HD022', '2023-12-17', '2023-12-18', 6000000, 100000, 5900000, 0, 9, 1, 2, N'Đơn hàng số 22', 2),
('HD023', '2023-12-18', '2023-12-19', 4500000, 50000, 4450000, 0, 9, 2, 3, N'Đơn hàng số 23', 3),
('HD024', '2023-12-19', '2023-12-20', 5500000, 200000, 5300000, 0, 10, 3, 1, N'Đơn hàng số 24', 4),
('HD025', '2023-12-20', '2023-12-21', 3000000, 100000, 2900000, 0, 10, 4, 2, N'Đơn hàng số 25', 5);


-- Insert into HoaDonChiTiet
INSERT INTO HoaDonChiTiet (IdSP, IdHD, SoLuong, DonGia)
VALUES (1, 1, 2, 2000000),
       (2, 1, 1, 3000000),
       (3, 2, 3, 1500000),
       (4, 3, 1, 3000000),
       (5, 4, 1, 3500000),
	   (1, 9, 2, 2000000),
  (2, 10, 1, 3000000),
  (3, 11, 3, 1500000),
  (4, 12, 1, 3000000),
  (5, 13, 2, 3500000),
  (1, 14, 2, 2000000),
  (2, 15, 1, 3000000),
  (3, 16, 3, 1500000),
  (4, 17, 1, 3000000),
  (5, 18, 2, 3500000),
  (1, 19, 2, 2000000),
  (2, 20, 1, 3000000),
  (3, 21, 3, 1500000),
  (4, 22, 1, 3000000),
  (5, 23, 2, 3500000);
SELECT * FROM HoaDonChiTiet;

SELECT A.MaSP, A.TenSP, B.TenLoaiSanPham, A.GiaBan, A.GiaNhap, A.HinhAnh, A.Mota, A.Soluong,C.TenMau,D.TenHangSanXuat,E.Size,A.TrangThai 
FROM SanPham A JOIN LoaiSanPham B ON A.IdLoaiSanPham=B.IdLoaiSanPham JOIN MauSac C ON A.IdMau=C.IdMau 
JOIN HangSanXuat D ON A.IdHang=D.IdHang JOIN SizeSP E ON A.IdSize=E.IdSize WHERE A.TrangThai = 0