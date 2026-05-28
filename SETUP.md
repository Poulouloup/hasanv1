# Setup

## 1 — Base ONNX models

`melspectrogram.onnx` and `embedding_model.onnx` are not included in the repo (too large).  
Download them from the official OpenWakeWord v0.5.1 release:

**Windows (PowerShell):**
```powershell
$base = "https://github.com/dscripka/openWakeWord/releases/download/v0.5.1"
Invoke-WebRequest "$base/melspectrogram.onnx"  -OutFile "app\src\main\assets\melspectrogram.onnx"
Invoke-WebRequest "$base/embedding_model.onnx" -OutFile "app\src\main\assets\embedding_model.onnx"
```

**Linux / macOS:**
```bash
BASE="https://github.com/dscripka/openWakeWord/releases/download/v0.5.1"
curl -L "$BASE/melspectrogram.onnx"  -o app/src/main/assets/melspectrogram.onnx
curl -L "$BASE/embedding_model.onnx" -o app/src/main/assets/embedding_model.onnx
```

## 2 — Local Hermes server

```bash
pip install fastapi uvicorn cryptography
cd server
python gen_cert.py 192.168.1.100    # replace with your local IP
python server.py
```

## 3 — Configure the app

Open the app → **Settings** tab → **Hermes Connection** section → enter the URL and token.

Dev defaults: `https://192.168.1.100:8443` / `HASAN_DEV_TOKEN`

## 4 — Build and install

```bash
./gradlew assembleDebug
adb install app/build/outputs/apk/debug/app-debug.apk
```
