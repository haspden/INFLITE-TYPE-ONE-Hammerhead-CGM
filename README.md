# INFLITE Type One

Application for [INFLITE TYPE ONE](https://inflite.cc/typeone/) riders to display glucose values from their continuous glucose monitors via [Nightscout](https://github.com/nightscout/cgm-remote-monitor) to a Hammerhead Karoo / Karoo 2 bike computer.

## Warning !

**_This app is in development and is not intended to be used to aid medical decisions._**

</br></br>

## Prerequisites !

1. This app requires the user to have an active [Nightscout](https://github.com/nightscout/cgm-remote-monitor) website. 
    
2. This app requires an active data connection to your Hammerhead Karoo / Karoo 2 Device.
    
    **_WARNING ! DATA CHARGES MAY APPLY_**

</br></br>

## Installation and Setup
1. **Download**

   * You can download the most up to date release of this app by viewing the [releases](https://github.com/haspden/INFLITE-TYPE-ONE-Hammerhead-CGM/releases)


2. **Installation**

    * Sideload / Install this app onto your Hammerhead Karoo / Karoo 2 Device.
    
    [DC Rainmaker provides instructions on sideloading here](https://www.dcrainmaker.com/2021/02/how-to-sideload-android-apps-on-your-hammerhead-karoo-1-karoo-2.html)

3. **Setup / Use**

    * Open the INFLITE TYPE ONE CGM App from the Apps screen on your Hammerhead Karoo / Karoo 2 Device.
    * Enter your own [Nightscout](https://github.com/nightscout/cgm-remote-monitor) API Endpoint URL into the URL bar.
        * This should be in the format https://yoursubdomain.yourdomain.tld/api/v1/entries/sgv.json
        * example = https://mybloodglucose.herokuapp.com/api/v1/entries/sgv.json
        
    * Set your interval preferences for how ofter you want the app to poll for new values. Most CGMs pull data every 5 minutes, however we have set the default interval to 1 minute (60 seconds) to ensure a timely update after the CGM updates [Nightscout](https://github.com/nightscout/cgm-remote-monitor) with it's data.
    
    * Amend your ride profiles to add the new data fields into position. There are several to choose from
        * **mmol/L** - Most recent blood glucose in mmol/L
        * **mg/dL** - Most recent blood glucose in mg/dL
        * **Direction Icons** - A graphical representation of the most recent direction
        * **Direction Text** - A textual representation of the most recent direction
        * **Direction History** - A graphical representation of the 5 most recent directions (right is most recent)
        * **Last Update Timestamp** - The timestamp of the last updated data
    
    * Direction graphical arrows and text strings are as follows
        * ↓︎↓︎ "DoubleDown"
        * ↓︎ "SingleDown"
        * ↘︎ "FortyFiveDown"
        * →︎ "Flat"
        * ↑︎ "SingleUp"
        * ↗︎ "FortyFiveUp"
        * ↑︎↑︎ "DoubleUp"

</br></br>

## About INFLITE TYPE ONE

[INFLITE TYPE ONE](https://inflite.cc/typeone/) are the UK's first and only cycling, running and triathlon teams to be made up entirely of athletes, living, racing the thriving with type one diabetes.
 
You can view more about the team by visiting https://inflitetypeone.cc

</br></br>

## Contact

If you have any questions relating to this app, please direct them to hammerheadcgm@inflitetypeone.cc

</br></br>

## Screenshots

![Application](media/app-configuration.png?raw=true "Application")
![App drawer](media/apps.png?raw=true "Application")
![Ride elements](media/ride-elements.png?raw=true "Ride elements")
![Ride elements 2](media/ride-elements2.png?raw=true "Ride elements")

