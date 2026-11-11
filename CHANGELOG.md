# Changelog

Semua perubahan dan riwayat rilis plugin **RemindMe** dicatat di dalam berkas ini.

Format berpatokan pada [Keep a Changelog](https://keepachangelog.com/en/1.0.0/) dan proyek ini mematuhi [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

---

## [1.0.1] - 2026-11-11

### 🐛 Fixed (Perbaikan Bug)
- **Sound tidak berbunyi:** ID sound sebelumnya diubah titik menjadi underscore (`block_note_block_chime`) sehingga tidak dikenali. Sekarang ID dipakai apa adanya (`block.note_block.chime`).
- **Permission `remindme.use`** kini dideklarasikan di `plugin.yml` dengan default `true`, sehingga pemain biasa bisa memakai `/remindme` sesuai dokumentasi.
- **Validasi `interval-seconds`:** nilai kurang dari 1 otomatis dinaikkan ke 1 detik dan dicatat sebagai peringatan di console.

### ✨ Changed (Perubahan)
- Versi di `/remindme` kini diambil otomatis dari metadata plugin (tidak lagi hardcode).
- Tambah tab-complete untuk `/remindme reload` (hanya untuk yang punya `remindme.admin`).
- Peringatan di console jika `target-worlds` kosong dan format ID sound tidak valid.
- README disesuaikan: Paper 26.2, Java 25, tidak mendukung Spigot murni.
- Rapikan `gradle.properties` (hapus `group`/`version` ganda).

---

## [1.0.0] - 2026-11-08

### 🚀 Added (Fitur Baru)
- **Initial Release:** Rilis versi perdana plugin RemindMe.
- **World Grouping System:** Fitur pemisahan target pengiriman broadcast berdasarkan nama *world* (misal: `lobby-group`, `vanilla-group`).
- **Min-Players Filter:** Fitur validasi batas minimal pemain online di world target sebelum broadcast dikirim.
- **Multi-Display Mode:** Opsi penayangan pesan di obrolan (`CHAT`), di atas hotbar (`ACTIONBAR`), dan di tengah layar (`TITLE`).
- **Adventure MiniMessage Support:** Dukungan warna gradien (`<gradient>`), *hover events*, dan *click events* pada pesan broadcast serta prefix global.
- **Audio Notification:** Integrasi pemutaran efek suara Minecraft per-grup pengumuman.
- **Message Delivery Logic:** Pengiriman pesan berbasis rotasi berurutan maupun acak (*random*).
- **Command Management:** Perintah `/remindme reload` untuk memuat ulang konfigurasi secara *real-time*.
- **Documentation & Config Comments:** Berkas `config.yml` lengkap dengan instruksi dan komentar panduan bahasa Indonesia.