# RemindMe 📢

**RemindMe** adalah plugin pesan otomatis (*auto-broadcast*) performa tinggi untuk server Minecraft (Paper API) yang dirancang modular, fleksibel, dan mendukung pengelompokan pesan berbasis dunia (*world groups*).

Plugin ini memungkinkan admin server mengirim pengumuman, tips, maupun promosi secara berkala dengan filter cerdas seperti batas minimal pemain online di world target, efek suara, serta format teks modern **Kyori Adventure MiniMessage**.

---

## ✨ Fitur Utama

- **World-Based Grouping:** Pesan dikelompokkan berdasarkan grup dunia (*World Groups*). Pemain di *Lobby* hanya akan menerima pesan khusus *Lobby*, sementara pemain di dunia *Vanilla/Survival* menerima pesan khusus *Vanilla*.
- **Min-Players Condition:** Filter jumlah pemain minimal per-world agar broadcast tidak berjalan saat dunia sepi.
- **Multi-Display Mode:** Dukungan penayangan pesan di 3 lokasi berbeda:
  - `CHAT` — Obrolan obrolan biasa di chat box.
  - `ACTIONBAR` — Teks melayang di atas hotbar item.
  - `TITLE` — Teks besar interaktif di tengah layar.
- **Modern MiniMessage Formatting:** Mendukung warna gradien, efek *bold/italic*, teks *hover*, dan *click events* (buka URL / jalankan *command*).
- **Sound Notifications:** Pilihan efek suara (*sound effect*) yang diputar saat pengumuman muncul.
- **Message Rotation & Randomization:** Opsi pengiriman pesan secara berurutan (*sequential*) atau acak (*random*).
- **Hot-Reload:** Perbarui konfigurasi secara *real-time* tanpa menghentikan server menggunakan `/remindme reload`.

---

## ⚙️ Persyaratan System

- **Minecraft Version:** Java Edition `26.2` (sesuai `api-version` di `plugin.yml`)
- **Server Software:** Paper atau turunannya (Purpur, dll). Spigot murni tidak didukung karena memakai Adventure API langsung.
- **Java Version:** Java 25+

---

## 🚀 Perintah & Permission

| Perintah | Deskripsi | Permission | Default |
| :--- | :--- | :--- | :--- |
| `/remindme` | Menampilkan info plugin dan bantuan | `remindme.use` | Everyone |
| `/remindme reload` | Memuat ulang berkas `config.yml` | `remindme.admin` | OP |

---

## 🛠️ Panduan Instalasi

1. Unduh berkas `RemindMe-1.0.1.jar`.
2. Lakukan *copy-paste* file `.jar` ke dalam folder `plugins/` di server Minecraft kamu.
3. Jalankan atau *restart* server untuk meregenerasi berkas `config.yml`.
4. Sesuaikan pesan dan grup di `plugins/RemindMe/config.yml`.
5. Jalankan `/remindme reload` untuk menerapkan perubahan.

---

## 👤 Pembuat

Dikembangkan oleh **BagusDev**.