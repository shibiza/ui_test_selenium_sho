Used tools: Java, Selenium WebDriver, Junit

The task:
Please find a scenario to automate below. Use Selenium 3+ or any Selenium wrapper + Java stack, add any logging and reporting libs.
Start page: https://www.sho.com
Browsers: Chrome

                ***

Scenario 1. Open the Homeland 501 Episode Guide page (/homeland/season/5/episode/1/separation-anxiety).
Expected results: Episode Guide page loads

                 ***

Scenario 2. Verify Episode Guide page functionality.
Expected results: 2.1. Verify after clicking on 'hamburger menu' (top left side of page) the navigation menu is displayed, and contains following items:
_Series, -Movies, -Sports, -Documentaries, -Free Full Episodes
i. Verify all items except 'Series' are hyperlinks.
ii. Click on 'x', Verify menu closed.

2.2. Verify 'Start Your Free Trial' mark red.

2.3. Preview functionality:
i.Verify 'Stream this episode', 'Watch Preview' are displayed on buttom left side of preview element.
ii.Verify after clicking on 'Stream This Episode' the 'START STREAMING NOW ON' pop up is displayed.
iii.Verify pop-up closed, after clicking on 'x'

        ***

Scenario 3. Click the Watch a Preview CTA.
Expected results: Video page loads for "Next on Episode 1" video (/video/38764/next-on-episode-1)

        ***

Scenario 4. Verify video player functionality during playback
Expected results: 
4. Video player functionality should:
a. Video should autoplay after page loads
b. Controls available:
i. play/pause
ii. volume on/off
iii. volume slider
iv. video timer with current time and video length time (format example: 0:05 / 0:30)
v. timeline scrubbing control
vi. fullscreen button
vii. In fullscreen mode:
1. the same controls as in 4.b.i – 4.b.vi.
2. non-fullscreen button
3. ESC key closes fullscreen mode
