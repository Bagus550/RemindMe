# Changelog

Semua perubahan dan riwayat rilis plugin **RemindMe** dicatat di dalam berkas ini.

Format berpatokan pada [Keep a Changelog](https://keepachangelog.com/en/1.0.0/) dan proyek ini mematuhi [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

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