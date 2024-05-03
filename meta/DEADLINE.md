# Deadline

Modify this file to satisfy a submission requirement related to the project
deadline. Please keep this file organized using Markdown. If you click on
this file in your GitHub repository website, then you will see that the
Markdown is transformed into nice-looking HTML.

## Part 1.1: App Description

> Please provide a friendly description of your app, including
> the primary functions available to users of the app. Be sure to
> describe exactly what APIs you are using and how they are connected
> in a meaningful way.

> **Also, include the GitHub `https` URL to your repository.**

TODO WRITE / REPLACE
My app called 'Weather Wit' integrates real-time weather from cities with
    quotes that match the city's weather. The user can enter the name of any city.
    When they press the 'Get Weather' button, the app will display the current
    weather conditions including temperature, wind speed, and a small descrition.
    Based on the weather, the app will retrieve and display a quote that matches the weather
    from the quotes api. The APIs I used are called GoWeather API, which provides real-time
    weather information for any city and Quotable API, which has an endpoint that allows
    people to search for quotes with a keyword. Depending on the weather, the app changes the
    search query to find a related quote. For example, if the weather was sunny, the app would
    find a quote related to that keyword.

    URL:
    https://github.com/hl25698/cs1302-api-app

## Part 1.2: APIs

> For each RESTful JSON API that your app uses (at least two are required),
> include an example URL for a typical request made by your app. If you
> need to include additional notes (e.g., regarding API keys or rate
> limits), then you can do that below the URL/URI. Placeholders for this
> information are provided below. If your app uses more than two RESTful
> JSON APIs, then include them with similar formatting.

### API 1

```
https://goweather.herokuapp.com/weather/Curitiba
```

This API's service sometimes returns a 503 status code, meaning the service goes temporarily unavailable.
    It usually goes back up after 5+ minutes. Try using
    curl -IL -X GET 'https://goweather.herokuapp.com/weather/{city}'
    with any city to see whether the API is down or not.

### API 2

```
https://api.quotable.io/search/quotes?query=sun
```

Rate limit: 180 requests per minute, per IP address
Only con about this API is that quotes related to weather keywords (sun, wind, etc,) is
    limited.

## Part 2: New

> What is something new and/or exciting that you learned from working
> on this project?

There are so many possibilities that have come to mind whilst working on this project.
    I realized that I could genuinely build an app of anything, with practically any API.
    This is a very fun and exciting idea that I could possibly incorporate into my future
    projects.

## Part 3: Retrospect

> If you could start the project over from scratch, what do
> you think might do differently and why?

I think I would choose another API to retrieve my weather information. The weather API I'm using
    right now is extremely faulty, as the service goes unavailable too many times.
    It's difficult to work with when I'm trying to test my app, and the API is unavailable.
    I would have to wait until the service comes back up.
