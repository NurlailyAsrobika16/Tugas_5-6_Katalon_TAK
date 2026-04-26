# Tugas_5-6_Katalon_TAK

## 📌 Deskripsi Project
Project ini merupakan API Automation Testing menggunakan **Katalon Studio** dengan public API dari [FakeRestAPI](https://fakerestapi.azurewebsites.net/index.html). Testing dilakukan pada 5 endpoint yaitu Activities, Authors, Books, CoverPhotos, dan Users dengan method GET, POST, PUT, dan DELETE.

---

## 🛠️ Tools yang Digunakan
- Katalon Studio Enterprise v10.4.3
- FakeRestAPI (https://fakerestapi.azurewebsites.net)
- Groovy (script language)
- Git & GitHub

---

## 🔗 Base URL
https://fakerestapi.azurewebsites.net

---

## 📂 Struktur Project

```
├── Object Repository
│   ├── Activities (DELETE, GET, POST, PUT)
│   ├── Authors (DELETE, GET, POST, PUT)
│   ├── Books (DELETE, GET, POST, PUT)
│   ├── CoverPhotos (DELETE, GET, POST, PUT)
│   └── Users (DELETE, GET, POST, PUT)
├── Test Cases
│   ├── TC001_Get_Activities
│   ├── TC002_Post_Activities
│   ├── TC003_Put_Activities
│   ├── TC004_Delete_Activities
│   ├── TC005_Get_Authors
│   ├── TC006_Post_Authors
│   ├── TC007_Put_Authors
│   ├── TC008_Delete_Authors
│   ├── TC009_Get_Books
│   ├── TC010_Post_Books
│   ├── TC011_Put_Books
│   ├── TC012_Delete_Books
│   ├── TC013_Get_CoverPhotos
│   ├── TC014_Post_CoverPhotos
│   ├── TC015_Put_CoverPhotos
│   ├── TC016_Delete_CoverPhotos
│   ├── TC017_Get_Users
│   ├── TC018_Post_Users
│   ├── TC019_Put_Users
│   └── TC020_Delete_Users
└── Test Suites
    └── Swagger_test
        ├── Smoke Test
        └── Regression Test
```

---

## 📋 Endpoint & Skenario Testing

### 1. Activities
| Method | Endpoint | Deskripsi |
|--------|----------|-----------|
| GET | /api/v1/Activities | Mengambil semua data activities |
| POST | /api/v1/Activities | Menambahkan data activity baru |
| PUT | /api/v1/Activities/1 | Mengupdate data activity |
| DELETE | /api/v1/Activities/1 | Menghapus data activity |

### 2. Authors
| Method | Endpoint | Deskripsi |
|--------|----------|-----------|
| GET | /api/v1/Authors | Mengambil semua data authors |
| POST | /api/v1/Authors | Menambahkan data author baru |
| PUT | /api/v1/Authors/1 | Mengupdate data author |
| DELETE | /api/v1/Authors/1 | Menghapus data author |

### 3. Books
| Method | Endpoint | Deskripsi |
|--------|----------|-----------|
| GET | /api/v1/Books | Mengambil semua data books |
| POST | /api/v1/Books | Menambahkan data book baru |
| PUT | /api/v1/Books/1 | Mengupdate data book |
| DELETE | /api/v1/Books/1 | Menghapus data book |

### 4. CoverPhotos
| Method | Endpoint | Deskripsi |
|--------|----------|-----------|
| GET | /api/v1/CoverPhotos | Mengambil semua data cover photos |
| POST | /api/v1/CoverPhotos | Menambahkan data cover photo baru |
| PUT | /api/v1/CoverPhotos/1 | Mengupdate data cover photo |
| DELETE | /api/v1/CoverPhotos/1 | Menghapus data cover photo |

### 5. Users
| Method | Endpoint | Deskripsi |
|--------|----------|-----------|
| GET | /api/v1/Users | Mengambil semua data users |
| POST | /api/v1/Users | Menambahkan data user baru |
| PUT | /api/v1/Users/1 | Mengupdate data user |
| DELETE | /api/v1/Users/1 | Menghapus data user |

---

## ✅ Verifikasi yang Dilakukan

**GET**
- Status code 200, bukan 404/500
- Response berupa list dan tidak kosong
- Setiap field tidak null dan tipe datanya sesuai (Integer/String)
- Nilai data sesuai yang diharapkan
- Elapsed time 0-5000ms dan content type application/json

**POST**
- Status code 200, bukan 404/500
- Field tidak null dan tipe datanya sesuai
- Nilai yang dikirim sama dengan response yang dikembalikan
- Field tidak kosong, elapsed time normal, content type application/json

**PUT**
- Status code 200, bukan 404/500
- Field tidak null dan tipe datanya sesuai
- Nilai yang diupdate sesuai dengan response
- ID yang dikembalikan sesuai dengan ID yang diupdate
- Elapsed time normal, content type application/json

**DELETE**
- Status code 200, bukan 404/500
- Elapsed time normal 0-5000ms
- Content type application/json

---

## 🧪 Test Suite

**Smoke Test** — menguji hanya method GET dari semua endpoint untuk memastikan API berjalan normal secara cepat.
- TC001_Get_Activities, TC005_Get_Authors, TC009_Get_Books, TC013_Get_CoverPhotos, TC017_Get_Users

**Regression Test** — menguji semua method (GET, POST, PUT, DELETE) dari semua endpoint untuk memastikan seluruh fitur berjalan dengan benar.
- TC001 sampai TC020 (semua test case)

---

## 📊 Hasil Testing
| Test Suite | Total TC | Passed | Failed |
|------------|----------|--------|--------|
| Smoke Test | 5 | 5 | 0 |
| Regression Test | 20 | 20 | 0 |

---

## 🎥 Demo Video
[Link video demo](#)

---

## 👤 Author
**Nurlaily Asrobika**
GitHub: @NurlailyAsrobika16(https://github.com/NurlailyAsrobika16)
