# JavaCPOS – Modern Java Swing POS System

![Java](https://img.shields.io/badge/Java-17-blue?logo=openjdk)
![Swing](https://img.shields.io/badge/Swing-UI-lightgrey)
![FlatLaf](https://img.shields.io/badge/Look%26Feel-FlatIntelliJLaf-green)
![Maven](https://img.shields.io/badge/Build-Maven-blue)
![License](https://img.shields.io/github/license/satellitegazor/javacpos)

A **clean, modern, MVC-based Point of Sale (POS)** system built with **Java Swing**, **FlatLaf**, and **pure Java**.

---

## Features

- **IntelliJ-style UI** with `FlatIntelliJLaf`
- **Dynamic menu**: Departments → Categories → Sale Items
- **Slim, aligned billing table** with `+ / –` quantity buttons
- **Hover-responsive footer buttons** (Customer, Checkout, Ticket Lookup, Cancel)
- **Customer lookup** (mocked or via API)
- **Checkout & Cancel** with confirmation
- **Immutable `SaleState`** + **Controller pattern**
- **API-ready** with `LTCClient` (Jackson + `HttpClient`)
- **Logging** with SLF4J + Logback

---

## Screenshots

> *(Add screenshots by dragging images into this repo)*

```markdown
<image-card alt="POS Main Screen" src="screenshot-main.png" ></image-card>
