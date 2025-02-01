import turtle

# Set up the screen
wn = turtle.Screen()
wn.bgcolor("white")
wn.title("Bouncing Ball Animation")


# Create a Turtle object for drawing the ball
ball = turtle.Turtle()
ball.shape("circle")
ball.color("blue")
ball.penup()
ball.goto(0, -200)
ball.speed(0)

# Set initial ball movement parameters
ball.dx = 3
ball.dy = 3

# Animation loop
while True:
    # Move the ball
    ball.sety(ball.ycor() + ball.dy)
    ball.setx(ball.xcor() + ball.dx)

    # Bounce the ball off the top and bottom
    if ball.ycor() > 200:
        ball.sety(200)
        ball.dy *= -1
        ball.color("red")

    if ball.ycor() < -200:
        ball.sety(-200)
        ball.dy *= -1
        ball.color("green")

    # Bounce the ball off the sides
    if ball.xcor() > 200:
        ball.setx(200)
        ball.dx *= -1
        ball.color("blue")

    if ball.xcor() < -200:
        ball.setx(-200)
        ball.dx *= -1
        ball.color("black")

wn.mainloop()