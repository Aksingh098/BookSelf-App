# BookSelf

BookSelf is an Android app built with **Kotlin** and **Jetpack Compose** that fetches books from the **Google Books API** and displays their covers in a responsive staggered grid.

## 🎥 Demo
[BookSelf.webm](https://github.com/user-attachments/assets/d81d70bc-89a2-4cd0-9cf1-b21cba290e1e)


## Features

- Compose-first UI with Material 3 styling.
- Loads books from Google Books using Retrofit + Kotlin serialization.
- Dependency container pattern (`AppContainer`) for data layer wiring.
- ViewModel-driven UI state handling (`Loading`, `Success`, `Error`).
- Retry flow for network failures.
- Automatic conversion of image URLs from `http` to `https` for safer image loading.

## Tech Stack

- **Language:** Kotlin
- **UI:** Jetpack Compose, Material 3
- **Architecture:** ViewModel + Repository pattern
- **Networking:** Retrofit, OkHttp, Kotlinx Serialization
- **Image Loading:** Coil
- **Build System:** Gradle (Kotlin DSL)

## Project Structure

```text
app/src/main/java/com/example/bookself/
├── data/
│   ├── AppContainer.kt         # DI-style object graph and Retrofit setup
│   └── BooksRepository.kt      # Repository interface + network implementation
├── model/
│   └── BookItem.kt             # API response models
├── network/
│   └── BooksApiService.kt      # Retrofit API contract
├── ui/
│   ├── BookHomeScreen.kt       # Loading/error/success composables and grid
│   ├── BookselfApp.kt          # App-level composables
│   └── BookselfViewModel.kt    # State + data loading logic
├── BookselfApplication.kt      # Application container initialization
└── MainActivity.kt             # Compose entry point
```

## Prerequisites

- Android Studio (latest stable recommended)
- Android SDK with:
  - `compileSdk = 36`
  - `minSdk = 24`
- JDK 11+

## Setup

1. Clone the repository.
2. Create or update `local.properties` in the project root.
3. Add your Google Books API key:

```properties
BOOKS_API_KEY=your_api_key_here
```

> The app reads `BOOKS_API_KEY` from `local.properties` and injects it into `BuildConfig` during build.

## Run the App

### Android Studio

1. Open the project in Android Studio.
2. Let Gradle sync complete.
3. Run the `app` configuration on an emulator or device.

### Command Line

```bash
./gradlew assembleDebug
```


## Current Behavior

- On launch, the app searches Google Books for `"Eichiro Oda"`.
- Results are displayed as a cover-image grid.
- If the request fails, an error message and **Retry** button are shown.

## Notes

- This project currently focuses on browsing cover thumbnails. Metadata such as title/author is already available in the model layer and can be surfaced in the UI as a next step.
- A valid API key is required for successful network calls.
