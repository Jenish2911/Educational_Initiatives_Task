# Educational Initiatives
## Task 1

### Overview
This project demonstrates six different design patterns in Java:
- **Behavioral Patterns**: Observer, Strategy
- **Creational Patterns**: Factory, Singleton
- **Structural Patterns**: Adapter, Decorator

Each use case focuses on solving real-world scenarios using specific design patterns.

---

### 1. **Observer Pattern** - Stock Market Monitoring System
Monitors stock prices and notifies registered investors when the stock price changes.

- **Classes**: `Investor`, `ConcreteInvestor`, `Stock`, `ConcreteStock`
- **Demo Class**: `StockMarketMonitoring`

#### To Run:
```bash
javac StockMarketMonitoring.java
java StockMarketMonitoring
```

---

### 2. **Strategy Pattern** - Payment Processing System
Dynamically selects a payment method (Credit Card, PayPal) for a shopping cart.

- **Classes**: `PaymentStrategy`, `CreditCardPayment`, `PayPalPayment`, `ShoppingCart`
- **Demo Class**: `PaymentProcessingSystem`

#### To Run:
```bash
javac PaymentProcessingSystem.java
java PaymentProcessingSystem
```

---

### 3. **Factory Pattern** - Notification System
Creates different types of notifications (Email, SMS, Push) using a factory method.

- **Classes**: `Notification`, `EmailNotification`, `SMSNotification`, `PushNotification`, `NotificationFactory`
- **Demo Class**: `NotificationSystem`

#### To Run:
```bash
javac NotificationSystem.java
java NotificationSystem
```

---

### 4. **Singleton Pattern** - Logger System
Ensures only one instance of the logger is created and used throughout the application.

- **Classes**: `Logger`
- **Demo Class**: `LoggerSystem`

#### To Run:
```bash
javac LoggerSystem.java
java LoggerSystem
```

---

### 5. **Adapter Pattern** - Media Player Adapter
Adapts different media formats (MP3, VLC, MP4) for a media player.

- **Classes**: `MediaPlayer`, `MediaAdapter`, `AdvancedMediaPlayer`, `VlcPlayer`, `Mp4Player`, `AudioPlayer`
- **Demo Class**: `MediaPlayerAdapter`

#### To Run:
```bash
javac MediaPlayerAdapter.java
java MediaPlayerAdapter
```

---

### 6. **Decorator Pattern** - Coffee Shop
Adds condiments (Milk, Sugar) to a base coffee dynamically.

- **Classes**: `Coffee`, `SimpleCoffee`, `CoffeeDecorator`, `MilkDecorator`, `SugarDecorator`
- **Demo Class**: `CoffeeShop`

#### To Run:
```bash
javac CoffeeShop.java
java CoffeeShop
```

---

## Task 2