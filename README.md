# GradesList

An Android app for keeping track of your school grades. Add a grade for a subject, edit or delete it, and see your average grade update automatically.

## Features

- Add a grade with the subject name (grades from 1 to 5)
- List of all saved grades
- Edit or delete a single grade, or clear the whole list
- Average grade calculated live from the database
- Data is stored locally, so it survives app restarts

## Tech stack

- **Kotlin**
- **Room** for local SQLite storage
- **MVVM**: `ViewModel` + `LiveData` + repository
- **Navigation Component** with Safe Args (passing a grade to the edit screen)
- **RecyclerView** and View Binding
- Min SDK 28, target SDK 35

## Project structure

```
app/src/main/java/com/example/gradeslist/
├── data/          # Room database and DAO
├── model/         # Grades entity
├── repository/    # GradesRepository
├── viewmodel/     # GradeViewModel
└── fragments/
    ├── list/      # Grades list + RecyclerView adapter
    ├── add/       # Add grade screen
    └── update/    # Edit / delete grade screen
```

## Getting started

1. Clone the repository:
   ```bash
   git clone https://github.com/ViktorUw/GradesList.git
   ```
2. Open the project in **Android Studio** and let Gradle sync.
3. Run the app on an emulator or a device with Android 9.0 (API 28) or newer.

> The user interface is in Polish.
