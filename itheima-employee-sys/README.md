# itheima-employee-sys

## Swing Login UI Demo (Enterprise Style)

This module now includes a polished Swing login screen in:

- `src/com/yanyuuki/ui/LoginUI.java`

### Features

- Enterprise-style split card layout (brand panel + login panel)
- Chinese system title: `人事管理系统`
- Soft workspace background + premium card border style
- Nimbus look and feel (falls back automatically if unavailable)
- Username/password input area with clean spacing
- Show password checkbox
- Remember me checkbox (UI demo)
- Keyboard shortcuts:
  - Enter: submit login
  - Esc: reset form
- Demo credentials:
  - Username: `admin`
  - Password: `123456`

### Compile and run (PowerShell)

```powershell
Push-Location "D:\code\javaseaiproject\itheima-employee-sys"
New-Item -ItemType Directory -Force -Path out | Out-Null
javac -d out src\com\yanyuuki\ui\LoginUI.java
java -cp out com.yanyuuki.ui.LoginUI
Pop-Location
```

## Swing Employee Manager UI Demo

This module also includes an employee information management screen in:

- `src/com/yanyuuki/ui/EmployeeManagerUI.java`

### Features

- Top row centered controls: keyword input + `Search` button + `Add` button
- Middle `JTable` with 20 initial employee records
- Right-click on each row to open context menu: `Edit` / `Delete`
- Add, edit, delete actions refresh the table immediately
- Search supports ID, name, department, and phone filtering

### Compile and run (PowerShell)

```powershell
Push-Location "D:\code\javaseaiproject\itheima-employee-sys"
New-Item -ItemType Directory -Force -Path out | Out-Null
javac -d out src\com\yanyuuki\ui\EmployeeManagerUI.java
java -cp out com.yanyuuki.ui.EmployeeManagerUI
Pop-Location
```

## File-based Auth and Data

- `LoginUI` now reads users from `data/users.txt`
- `RegisterUI` writes newly registered users to `data/users.txt`
- `EmployeeManagerUI` reads/writes employees in `data/employees.txt`
- On successful login, `LoginUI` opens `EmployeeManagerUI` and passes the logged-in username

### Full compile and run (PowerShell)

```powershell
Push-Location "D:\code\javaseaiproject\itheima-employee-sys"
New-Item -ItemType Directory -Force -Path out | Out-Null
javac -d out src\com\yanyuuki\ui\UserAccount.java src\com\yanyuuki\ui\UserStore.java src\com\yanyuuki\ui\RegisterUI.java src\com\yanyuuki\ui\LoginUI.java src\com\yanyuuki\ui\EmployeeManagerUI.java
java -cp out com.yanyuuki.ui.LoginUI
Pop-Location
```

