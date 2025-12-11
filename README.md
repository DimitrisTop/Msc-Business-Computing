# MSc Business Computing

This repository contains all coursework, projects, and materials for the MSc in Business Computing program.

## Repository Structure

```
Msc-Business-Computing/
├── Semester-1/
│   └── Projects/
│       ├── Project1/
│       └── Project2/
└── README.md
```

## Getting Started

Navigate to the respective semester and project directories to access course materials and assignments.

### Semester 1

See [Semester-1/README.md](Semester-1/README.md) for details about first semester coursework.

## How to Add New Content

1. Navigate to the appropriate semester directory
2. Add your files to the relevant project folder
3. Update the README files as needed

### Adding Java Files

Java source files (`.java`) can be added directly to any project directory:

1. Create or copy your `.java` files into the appropriate project folder
2. Stage the files: `git add <filename>.java`
3. Commit: `git commit -m "Add Java source files"`
4. Push: `git push`

**Note**: The repository's `.gitignore` is configured to:
- ✅ **Allow** Java source files (`.java`)
- ❌ **Exclude** compiled class files (`.class`)
- ❌ **Exclude** JAR files and other build artifacts
- ❌ **Exclude** IDE configuration files

Example Java file can be found at: `Semester-1/Projects/Project1/HelloWorld.java`

## Additional Semesters

To add additional semesters, create new directories following the same pattern:
- Semester-2/
- Semester-3/
- etc.