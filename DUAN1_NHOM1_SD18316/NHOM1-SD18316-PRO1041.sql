CREATE DATABASE PTPM_JAVA_FA23_PRO1041;
GO
USE PTPM_JAVA_FA23_PRO1041
GO
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
TrangThai nvarchar(50),
TaiKhoan nvarchar(50),
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
--SAN PHAM--
CREATE TABLE SanPham(
IdSP INT IDENTITY PRIMARY KEY,
MaSP nvarchar(50),
TenSP nvarchar(100),
IdLoaiSanPham UNIQUEIDENTIFIER,
TrangThai nvarchar(50),
GiaBan float,
GiaNhap float,
Mota nvarchar(50),
Soluong int,
IdNV INT ,
IdMau INT ,
IdHang INT,
IdSize INT,
IdKM INT,
)
GO
CREATE TABLE KhuyenMai(
IdKM INT IDENTITY PRIMARY KEY,
MaKM nvarchar(50),
TenKM nvarchar(100),
NgayBatDau date,
NgayKetThuc date,
DieuKien float,
TienGiam float,
TrangThai nvarchar(50)
)
GO
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
TrangThai nvarchar(50),
IdNV INT
)
GO
CREATE TABLE GioHang(
IdGioHang INT IDENTITY PRIMARY KEY,
MaGioHang NVARCHAR(50),
NgayTao DATE DEFAULT NULL,
NgayThanhToan DATE DEFAULT NULL,
Soluong INT,
DonGia FLOAT,
TienGiam FLOAT,
IdKH INT,
IdNV INT,
IdSP INT,
IdKM INT
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
TrangThai nvarchar(50),
NguoiLap INT,
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
ADD CONSTRAINT FK_SanPham_MauSac
FOREIGN KEY (IdMau) REFERENCES MauSac(IdMau);

ALTER TABLE SanPham
ADD CONSTRAINT FK_SanPham_HangSanXuat
FOREIGN KEY (IdHang) REFERENCES HangSanXuat(IdHang);

ALTER TABLE SanPham
ADD CONSTRAINT FK_SanPham_SizeSP
FOREIGN KEY (IdSize) REFERENCES SizeSP(IdSize);

ALTER TABLE SanPham
ADD CONSTRAINT FK_SanPham_KhuyenMai
FOREIGN KEY (IdKM) REFERENCES KhuyenMai(IdKM);

ALTER TABLE HoaDon
ADD CONSTRAINT FK_HoaDon_NguoiLap
FOREIGN KEY (NguoiLap) REFERENCES NhanVien(IdNV);

ALTER TABLE HoaDonChiTiet
ADD CONSTRAINT FK_HoaDon_HoaDonCT
FOREIGN KEY (IdHD) REFERENCES HoaDon(IdHD);

ALTER TABLE KhachHang
ADD CONSTRAINT FK_KhachHang_NhanVien
FOREIGN KEY (IdNV) REFERENCES NhanVien(IdNV);

ALTER TABLE HoaDon
ADD CONSTRAINT FK_HoaDon_KhachHang
FOREIGN KEY (IdKH) REFERENCES KhachHang(IdKH);

ALTER TABLE HoaDonChiTiet
ADD CONSTRAINT FK_SanPham_HoaDonCT
FOREIGN KEY (IdSP) REFERENCES SanPham(IdSP);

ALTER TABLE SanPham
ADD CONSTRAINT FK_SanPham_NhanVien
FOREIGN KEY (IdNV) REFERENCES NhanVien(IdNV);

ALTER TABLE SanPham
ADD CONSTRAINT FK_SanPham_LoaiSanPham
FOREIGN KEY (IdLoaiSanPham) REFERENCES LoaiSanPham(IdLoaiSanPham);

ALTER TABLE GioHang
ADD CONSTRAINT FK_SanPham_GioHang
FOREIGN KEY (IdSP) REFERENCES SanPham(IdSP);

ALTER TABLE GioHang
ADD CONSTRAINT FK_KhachHang_GioHang
FOREIGN KEY (IdKH) REFERENCES KhachHang(IdKH);

ALTER TABLE GioHang
ADD CONSTRAINT FK_NhanVien_GioHang
FOREIGN KEY (IdNV) REFERENCES NhanVien(IdNV);

ALTER TABLE GioHang
ADD CONSTRAINT FK_KhuyenMai_GioHang
FOREIGN KEY (IdKM) REFERENCES KhuyenMai(IdKM);